name := """play-scala-microservice"""

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  "com.ofg" % "micro-deps" % "0.3.1",
  "com.wordnik" % "swagger-play2_2.10" % "1.3.7",
  "com.google.guava" % "guava" % "14.0"
)

//lazy val root = (project in file(".")).addPlugins(PlayScala)

play.Project.playScalaSettings