name := """play-scala-microservice"""

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  "com.ofg" % "micro-deps" % "0.3.1"
)

lazy val root = (project in file(".")).addPlugins(PlayScala)
