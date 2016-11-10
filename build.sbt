import de.heikoseeberger.sbtheader.HeaderPattern
headers := Map(
  "scala" -> (
    HeaderPattern.cStyleBlockComment,
    s"""/* Copyright (c) 2016 CiBO Technologies - All Rights Reserved
        | * You may use, distribute, and modify this code under the
        | * terms of the BSD 3-Clause license.
        | *
        | * A copy of the license can be found on the root of this repository,
        | * at ${homepage.value.get.toString}/LICENSE.md,
        | * or at https://opensource.org/licenses/BSD-3-Clause
        | */
        |
       |""".stripMargin
    )
)

name := "leaflet-facade"
organization := "com.cibo"

homepage := Some(url("https://github.com/cibotech/leaflet-facade"))
licenses += ("BSD Simplified", url("https://opensource.org/licenses/BSD-3-Clause"))
scmInfo := Some(ScmInfo(
  url("https://github.com/cibotech/leaflet-facade"),
  "scm:git:git@github.com/cibotech/leaflet-facade.git",
  Some("scm:git:git@github.com/cibotech/leaflet-facade.git")))

publishMavenStyle := true
publishArtifact in Test := false
publishArtifact in IntegrationTest := false

scalaVersion := "2.11.8"
crossScalaVersions := Seq("2.10.5", "2.11.8")
releaseCrossBuild := true

lazy val root = project.in(file("."))
    .settings(
      name := "LeafletExample",
      version := "1.0.0-RC1",
      persistLauncher in Compile := true,
      libraryDependencies ++= Seq(
        "org.scala-js" %%% "scalajs-dom" % "0.9.0",
        "com.github.karasiq" % "scalajs-marked_sjs0.6_2.11" % "1.0.1",
        "be.doeraene" %%% "scalajs-jquery" % "0.9.0",
        "com.lihaoyi" %%% "scalatags" % "0.6.0"
      ),
      jsDependencies ++= Seq(
        "org.webjars.bower" % "leaflet" % "1.0.0-rc.1"
          / "leaflet.js"
      ),
      requiresDOM := true,
      scalaJSStage in Test := FastOptStage,
      persistLauncher in Compile := true,
      persistLauncher in Test := false
    )
  .enablePlugins(ScalaJSPlugin)

//lazy val example = project.in(file("."))
//    .settings(
//      name := "LeafletExample",
//      version := "0.1-SNAPSHOT",
//      persistLauncher in Compile := true,
//      persistLauncher in Test := false,
//      libraryDependencies ++= Seq(
//        "org.scala-js" %%% "scalajs-dom" % "0.9.0"
//      )
//    )
//  .enablePlugins(ScalaJSPlugin)
