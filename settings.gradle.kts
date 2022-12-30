pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Gooder"
include(
    ":app",
    ":core:ui-compose",
    ":core:ui-designsystem",
    ":core:ui-resources"
)
