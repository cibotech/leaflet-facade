import ReleaseTransformations._

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
)

bintrayOrganization  := Some("cibotech")
bintrayRepository    := "public"
bintrayPackageLabels := Seq("scala", "scala.js", "leaflet")