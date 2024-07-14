repositories {
    mavenCentral()
}

plugins {
    id("org.jetbrains.kotlin.jvm")
}

dependencies {
    // Dependencies for test
    testImplementation(libs.junit.jupiter)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // Dependency used by the application
    implementation(libs.guava)
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

tasks.register("task3") {
    println("REGISTER TASK3: This is executed during the configuration phase")
}

tasks.named("task3") {
    println("NAMED TASK3: This is executed during the configuration phase")
    doFirst {
        println("NAMED TASK3 - doFirst: This is executed during the execution phase")
    }
    doLast {
        println("NAMED TASK3 - doLast: This is executed during the execution phase")
    }
}