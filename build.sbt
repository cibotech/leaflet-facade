import ReleaseTransformations._
import execnpm.NpmDeps.Dep


homepage := Some(url("https://github.com/cibotech/leaflet-facade"))

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
       |""".stripMargin)
)

// How does this now work !?
//commentStyle := CommentStyle.cStyleBlockComment

lazy val globalSettings = Seq(
  organization := "com.cibo",
  scmInfo := Some(ScmInfo(
    url("https://github.com/cibotech/leaflet-facade"),
    "scm:git:git@github.com/cibotech/leaflet-facade.git",
    Some("scm:git:git@github.com/cibotech/leaflet-facade.git"))),
  publishMavenStyle := true,
  publishArtifact in Test := false,
  publishArtifact in IntegrationTest := false,
  scalaVersion := "2.12.4",
  crossScalaVersions := Seq("2.11.8", "2.12.4"),
  releaseCrossBuild := true,
  releaseProcess := Seq[ReleaseStep](
    checkSnapshotDependencies,
    inquireVersions,
    releaseStepCommand("createHeaders"),
    setReleaseVersion,
    commitReleaseVersion,
    tagRelease,
    publishArtifacts,
    setNextVersion,
    commitNextVersion,
    pushChanges
  ),
  bintrayOrganization := Some("cibotech"),
  bintrayRepository := "public",
  bintrayPackageLabels := Seq("scala", "scala.js", "leaflet"),
  licenses += ("BSD Simplified", url("https://opensource.org/licenses/BSD-3-Clause"))
)

lazy val `leaflet-facade` = project.in(file("leaflet"))
  .settings(globalSettings)
  .settings(
    crossScalaVersions := Seq("2.11.8", "2.12.4"),
    releaseCrossBuild := true,
    name := "leaflet-facade",
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % "0.9.4"
    ),
    npmDeps in Compile += Dep("leaflet", "1.3.4", List("leaflet.js"))
  ) enablePlugins (ExecNpmPlugin)

lazy val `leaflet-draw` = project.in(file("leaflet-draw"))
  .settings(globalSettings)
  .settings(
    crossScalaVersions := Seq("2.11.8", "2.12.4"),
    releaseCrossBuild := true,
    name := "leaflet-draw-facade",
    npmDeps in Compile += Dep("leaflet-draw", "1.0.4", List("leaflet.draw.js"))
  ) dependsOn (`leaflet-facade`) enablePlugins (ExecNpmPlugin)

lazy val `leaflet-pm` = project.in(file("leaflet-pm"))
  .settings(globalSettings)
  .settings(
    crossScalaVersions := Seq("2.11.8", "2.12.4"),
    releaseCrossBuild := true,
    name := "leaflet-pm",
    npmDeps in Compile += Dep("leaflet.pm", "0.25.0", List("leaflet.pm.min.js"), true)
  ) dependsOn (`leaflet-facade`) enablePlugins (ExecNpmPlugin)


lazy val buildExample = taskKey[Unit]("build")
lazy val example = project.in(file("example"))
  .settings(
    crossScalaVersions := Seq("2.11.8", "2.12.4"),
    releaseCrossBuild := true,
    publishArtifact := false,
    name := "leaflet-example",
    publish := {},
    buildExample := {
      val exampleTarget = (target in Compile).value
      val exampleResource = (resourceDirectory in Compile).value
      val buildJS = (fullOptJS in Compile).value

      // Copy js and deps files and resource directory in exemple target
      IO.copyFile(buildJS.data, exampleTarget / "js/leaflet-facade.js")
      IO.copyFile(dependencyFile.value, exampleTarget / "js/leaflet-facade-deps.js")
      IO.copyDirectory(exampleResource, exampleTarget)
    }) enablePlugins (ExecNpmPlugin) dependsOn(`leaflet-pm`, `leaflet-draw`)