package infrastructure

import play.api.libs.json.{JsError, Json, Writes, Reads}
import play.api.mvc.BodyParsers.parse
import play.api.mvc.{Results, Action}

/**
 *
 *
 * @author Lukasz Olczak
 */
object ServiceAction extends Results {

  def apply[I: Reads, R: Writes](block: I => R) = Action(parse.json) {
    request =>
      val json = request.body
      json.validate[I].fold(
        valid = {
          input =>
            val result = block(input)
            Ok(Json.toJson(result))
        },
        invalid = {
          errors =>
            BadRequest(JsError.toFlatJson(errors))
              .as("application/json")
        }
      )
  }

}
