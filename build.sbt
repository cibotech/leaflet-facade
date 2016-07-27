lazy val root = project.in(file(".")).
  enablePlugins(ScalaJSPlugin)

name := "leaflet-facade"

version := "1.0"

scalaVersion := "2.11.8"

scalaVersion := "2.11.8"

crossScalaVersions := Seq("2.10.5", "2.11.8")

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.9.0"
)

homepage := Some(url("https://github.com/cibotech/leaflet-facade"))

jsDependencies ++= Seq(
  "org.webjars.bower" % "leaflet" % "1.0.0-rc.1"
    / "leaflet.js"
)


/**
  * If eventually publishing
  */
//licenses += ("MIT License", url("http://www.opensource.org/licenses/mit-license.php"))

//scmInfo := Some(ScmInfo(
//  url("https://github.com/cibotech/leaflet-facade"),
//  "scm:git:git@github.com/cibotech/leaflet-facade.git",
//  Some("scm:git:git@github.com/cibotech/leaflet-facade.git")))
//
//publishMavenStyle := true
//
//publishTo := {
//  val nexus = "https://oss.sonatype.org/"
//  if (isSnapshot.value)
//    Some("snapshots" at nexus + "content/repositories/snapshots")
//  else
//    Some("releases" at nexus + "service/local/staging/deploy/maven2")
//}

//pomExtra := (
//  <developers>
//    <developer>
//      <id></id>
//      <name></name>
//      <url>https://github.com/cibotech/leaflet-facade</url>
//    </developer>
//  </developers>
//  )
//pomIncludeRepository := { _ => false }
