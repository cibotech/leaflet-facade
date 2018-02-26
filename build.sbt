lazy val globalSettings = Seq(
  headerLicense := Some(HeaderLicense.Custom(
      s"""/* Copyright (c) 2018 CiBO Technologies - All Rights Reserved
         | * You may use, distribute, and modify this code under the
         | * terms of the BSD 3-Clause license.
         | *
         | * A copy of the license can be found on the root of this repository,
         | * at ${homepage.value.get.toString}/LICENSE.md,
         | * or at https://opensource.org/licenses/BSD-3-Clause
         | */
         |
       |""".stripMargin
  )),
  organization := "com.cibo",
  organizationName := "CiBO Technologies",
  homepage := Some(url("https://github.com/cibotech/leaflet-facade")),
  licenses += ("BSD Simplified", url("https://opensource.org/licenses/BSD-3-Clause")),
  scmInfo := Some(ScmInfo(
    url("https://github.com/cibotech/leaflet-facade"),
    "scm:git:git@github.com/cibotech/leaflet-facade.git",
    Some("scm:git:git@github.com/cibotech/leaflet-facade.git"))),
  publishMavenStyle := true,
  publishArtifact in Test := false,
  publishArtifact in IntegrationTest := false,
  scalaVersion := "2.12.4",
  crossScalaVersions := Seq("2.11.8", "2.12.4"),
  releaseCrossBuild := true
)

lazy val root = project.in(file("."))
    .aggregate(`leaflet-facade`, `leaflet-draw`)
    .settings(
      publishArtifact := false
    )

lazy val `leaflet-facade` = project.in(file("leaflet"))
    .settings(globalSettings)
    .settings(
      name := "leaflet-facade",
      libraryDependencies ++= Seq(
        "org.scala-js" %%% "scalajs-dom" % "0.9.4"
      ),
      jsDependencies ++= Seq(
        "org.webjars.bower" % "leaflet" % "1.2.0"
          / "leaflet.js"
      )
    )
  .enablePlugins(ScalaJSPlugin)

lazy val `leaflet-draw` = project.in(file("leaflet-draw"))
  .settings(globalSettings)
  .settings(
    name := "leaflet-draw-facade",
    jsDependencies ++= Seq(
      "org.webjars.bower" % "leaflet-draw" % "0.4.9"
        / "leaflet.draw.js"
    )
  )
  .dependsOn(`leaflet-facade`)
  .enablePlugins(ScalaJSPlugin)
