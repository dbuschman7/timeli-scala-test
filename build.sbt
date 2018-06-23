autoScalaLibrary := false

scalaVersion := "2.12.6"

version := "0.0.1"

organization := "io.timeli"

resolvers += "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq (
	"com.typesafe.play" %% "play-json" % "2.6.8",
	"org.scalatest"     %% "scalatest" % "3.0.5" % "test"
)

