val jenaVersion = "3.12.0"


// Adapted from https://leonard.io/blog/2017/01/an-in-depth-guide-to-deploying-to-maven-central/ and
// https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html
developers := List(Developer("nfusionsz",
  "Owen Xie",
  "xieo@rpi.edu",
  url("https://github.com/nfusionz")),
  Developer("gordom6",
    "Minor Gordon",
    "gordom6@rpi.edu",
    url("https://github.com/gordom6")))
homepage := Some(url("https://github.com/tetherless-world/scena"))
libraryDependencies ++= Seq(
  "io.lemonlabs" %% "scala-uri" % "1.5.1",
  "org.apache.jena" % "jena-core" % jenaVersion,
  "org.apache.jena" % "jena-geosparql" % jenaVersion,
  "org.scalatest" %% "scalatest" % "3.0.8" % Test,
  "org.slf4j" % "slf4j-simple" % "1.7.26" % Test
)
licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0"))
name := "scena"
organization := "io.github.tetherless-world"
publishMavenStyle := true
publishTo := Some(
  if (isSnapshot.value)
    Opts.resolver.sonatypeSnapshots
  else
    Opts.resolver.sonatypeStaging
)
scalaVersion in ThisBuild := "2.12.10"
scmInfo := Some(ScmInfo(url("https://github.com/tetherless-world/scena"), "git@github.com:tetherless-world/scena.git"))
testOptions += Tests.Argument(TestFrameworks.JUnit, "-q", "-v")
//useGpg := false
version := "1.0.1-SNAPSHOT"
