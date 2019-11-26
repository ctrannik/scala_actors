name := "scala_actors"

version := "0.0.1"

scalaVersion := "2.13.0"

libraryDependencies ++= Seq(
	"com.typesafe.akka" %% "akka-actor"   % "2.6.0",
	"com.typesafe.akka" %% "akka-remote" % "2.6.0"
)