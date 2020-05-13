import Dependencies._

ThisBuild / scalaVersion     := "2.13.2"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val bar =
  project
    .in(file("bar"))

lazy val buzz =
  project
    .in(file("buzz"))

lazy val foo =
  project
    .in(file("foo"))
    .settings(
      Compile / unmanagedSourceDirectories ++= Seq(
        (bar / Compile / scalaSource).value,
        (buzz / Compile / scalaSource).value
      )
    )
