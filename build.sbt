name := """play-scala-microservice"""

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  "com.ofg" % "micro-deps" % "0.5.0",
  "com.wordnik" % "swagger-play2_2.10" % "1.3.7",
  "com.google.guava" % "guava" % "14.0",
  "org.scala-lang" % "scala-library" % "2.10.4"
)

//lazy val root = (project in file(".")).addPlugins(PlayScala)

play.Project.playScalaSettings