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

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include(
    ":app",
    ":base",
    ":core:ui-compose",
    ":core:ui-designsystem",
    ":core:ui-resources",
    ":shared:core-api-result",
    ":shared:core-di",
    ":shared:network:api",
    ":shared:network:implementation",
)
