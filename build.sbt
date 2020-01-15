
lazy val root = (project in file("."))
    .settings(
      libraryDependencies ++= Seq(
        "com.novocode" % "junit-interface" % "0.11" % "test",
        "io.lemonlabs" %% "scala-uri" % "1.5.1",
        "org.apache.jena" % "jena-core" % jenaVersion,
        "org.apache.jena" % "jena-geosparql" % jenaVersion,
        "org.scalatest" %% "scalatest" % "3.0.8" % "test",
        "org.slf4j" % "slf4j-simple" % "1.7.26"
      ),
      name := "scena",
      organization := "io.github.tetherless-world",
      testOptions += Tests.Argument(TestFrameworks.JUnit, "-q", "-v"),
      version := "1.0.0-SNAPSHOT"
    )

scalaVersion in ThisBuild := "2.12.10"
val jenaVersion = "3.12.0"
