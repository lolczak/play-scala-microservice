import com.wordnik.swagger.config.ConfigFactory
import com.wordnik.swagger.model.ApiInfo
import play.api.{Application, GlobalSettings}

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

  override def onStart(app: Application): Unit = super.onStart(app)

  override def onStop(app: Application): Unit = super.onStop(app)

}
