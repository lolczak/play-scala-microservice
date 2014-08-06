package controllers

import com.wordnik.swagger.annotations._
import scala.Array
import api.Ping
import api.Pong
import infrastructure.ServiceAction

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
  def ping = ServiceAction { ping: Ping => Pong(ping.msg) }

}
