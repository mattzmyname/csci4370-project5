name := """AirportProject"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava,PlayEbean)

scalaVersion := "2.11.11"

libraryDependencies += evolutions
libraryDependencies += jdbc
libraryDependencies += javaJdbc
libraryDependencies += cache
libraryDependencies += javaWs
<<<<<<< HEAD
libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.36"
libraryDependencies += "com.typesafe.play" %% "anorm" % "2.4.0"
=======
libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.36"
>>>>>>> 967060b11075c0467d2b79f813ec7774e7ad00b0
