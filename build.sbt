lazy val root = project.in(file(".")).
  enablePlugins(ScalaJSPlugin)

name := "leaflet-facade"

version := "1.0"

scalaVersion := "2.11.8"

version := "1.0-RC6"

organization := "org.querki"

scalaVersion := "2.11.8"

crossScalaVersions := Seq("2.10.5", "2.11.8")

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.9.0"
)

jsDependencies in Test += RuntimeDOM

/**
  * If eventually publishing
  */
//homepage := Some(url("http://github/"))
//
//licenses += ("MIT License", url("http://www.opensource.org/licenses/mit-license.php"))
//
//scmInfo := Some(ScmInfo(
//  url("https://github.com/  "),
//  "scm:git:git@github.com:  .git",
//  Some("scm:git:git@github.com:   .git")))
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
//      <name>Mark Waks</name>
//      <url>https://github.com/jducoeur/</url>
//    </developer>
//  </developers>
//  )

pomIncludeRepository := { _ => false }
