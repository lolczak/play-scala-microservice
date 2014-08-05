package api

import play.api.libs.json._
import play.api.libs.functional.syntax._

/**
 *
 *
 * @author Lukasz Olczak
 */
case class Ping(msg: String)

object Ping {

  implicit val format: Format[Ping] = (JsPath \ "ping").format[String].inmap(Ping.apply, unlift(Ping.unapply))

}

case class Pong(msg: String)

object Pong {

  implicit val format: Format[Pong] = (JsPath \ "pong").format[String].inmap(Pong.apply, unlift(Pong.unapply))

}
