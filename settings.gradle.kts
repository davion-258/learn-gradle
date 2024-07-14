/*
 Representing Setting object
 */

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

plugins {
    // Apply the foojay-resolver plugin to allow automatic download of JDKs
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

println("Running settings.gradle script")

rootProject.name = "learn-gradle"
include("app")
include("lib")

includeBuild("gradle/license-plugin")   // Another gradle project (different settings.gradle.kts)