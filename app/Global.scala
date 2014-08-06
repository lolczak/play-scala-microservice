import com.ofg.infrastructure.discovery.util.MicroDepsService
import com.wordnik.swagger.config.ConfigFactory
import com.wordnik.swagger.model.ApiInfo
import play.api.{Application, GlobalSettings}
import scala.io.Source

/**
 *
 *
 * @author Lukasz Olczak
 */
object Global extends GlobalSettings {

  val info = ApiInfo(
    title = "Play Scala Microservice API",
    description = """APIs for Play Scala Microservice template""",
    termsOfServiceUrl = "http://helloreverb.com/terms/",
    contact = "My Apps API Contact Email",
    license = "Apache 2.0",
    licenseUrl = "http://www.apache.org/licenses/LICENSE-2.0.html")

  ConfigFactory.config.setApiInfo(info)

  var pingService: MicroDepsService = _

  override def onStart(app: Application): Unit = {
    val pingDescr = app.resourceAsStream("microservice.json")

    pingService = new MicroDepsService(
      "127.0.0.1:2181", "ping", "http://localhost:9000", 9000, Source.fromInputStream(pingDescr.get).mkString
    )
    pingService.start()
  }

  override def onStop(app: Application): Unit = {
    pingService.stop()
  }

}
