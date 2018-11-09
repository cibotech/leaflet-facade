resolvers += Resolver.sonatypeRepo("releases")

addSbtPlugin("org.scala-js"      % "sbt-scalajs" % "0.6.25")
addSbtPlugin("de.heikoseeberger" % "sbt-header"  % "5.0.0")
addSbtPlugin("com.github.gseitz" % "sbt-release" % "1.0.9")
addSbtPlugin("org.foundweekends" % "sbt-bintray" % "0.5.4")
addSbtPlugin("org.scalastyle"    %% "scalastyle-sbt-plugin" % "1.0.0")
addSbtPlugin("fr.iscpif" % "scalajs-execnpm" % "0.1")