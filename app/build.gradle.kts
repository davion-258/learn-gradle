/*
 Representing Project object
 */

buildscript {
    repositories {
        mavenCentral()
    }
}

plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    // - {alias} is used to apply a plugin using an alias defined in the version catalog.
    // - {libs} references to the libs.versions.toml
    id("org.jetbrains.kotlin.jvm")

    // Apply the application plugin to add support for building a CLI application in Java.
    // - Auto add tasks assemble, build, and run
    application

    // Add custom plugin, add 'greeting' task
    id("com.example.license")
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Use JUnit Jupiter for testing.
    testImplementation(libs.junit.jupiter)

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // This dependency is used by the application.
    implementation(libs.guava)
    implementation(project(":lib"))
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

application {
    // Define the main class for the application.
    mainClass.set("org.example.AppKt")
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}

println("BUILD SCRIPT: This is executed during the configuration phase")

tasks.register("task1") {
    println("REGISTER TASK1: This is executed during the configuration phase")
}

tasks.register("task2") {
    println("REGISTER TASK2: This is executed during the configuration phase")
}

tasks.named("task1") {
    println("NAMED TASK1: This is executed during the configuration phase")
    doFirst {
        println("NAMED TASK1 - doFirst: This is executed during the execution phase")
    }
    doLast {
        println("NAMED TASK1 - doLast: This is executed during the execution phase")
    }
}

tasks.named("task2") {
    println("NAMED TASK2: This is executed during the configuration phase")
    doFirst {
        println("NAMED TASK2 - doFirst: This is executed during the execution phase")
    }
    doLast {
        println("NAMED TASK2 - doLast: This is executed during the execution phase")
    }
}