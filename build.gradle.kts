plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    // - {alias} is used to apply a plugin using an alias defined in the version catalog.
    // - {libs} references to the libs.versions.toml
    alias(libs.plugins.jvm)
}