autoScalaLibrary := false

scalaVersion := "2.12.4"

version := "0.0.1"

organization := "io.timeli"

resolvers += "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq (
	"com.typesafe.play" %% "play-json" % "2.6.8",
	"org.scalatest" %% "scalatest" % "3.0.4" % "test" //,
//	"junit" % "junit" % "4.12" % "test"
      )

