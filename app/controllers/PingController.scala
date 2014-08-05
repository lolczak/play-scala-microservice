package controllers

import play.api.mvc.Action
import play.api.libs.json.{Json, JsError}
import com.wordnik.swagger.annotations._
import scala.Array
import api.Ping
import api.Pong

/**
 *
 *
 * @author Lukasz Olczak
 */
@Api(value = "/ping", description = "Ping API")
object PingController extends BaseApiController {


  @ApiOperation(nickname = "ping",
    value = "Ping Server",
    response = classOf[Pong],
    httpMethod = "POST")
  @ApiResponses(Array(
    new ApiResponse(code = 405, message = "Invalid input")))
  @ApiImplicitParams(Array(
    new ApiImplicitParam(value = "Ping msg", required = true, dataType = "Ping", paramType = "body")))
  def ping = Action(parse.json) {
    request =>
      val json = request.body
      json.validate[Ping].fold(
        valid = {
          ping =>
            Ok(Json.toJson(Pong(ping.msg)))
        },
        invalid = {
          errors =>
            BadRequest(JsError.toFlatJson(errors))
        }
      )
  }

}
