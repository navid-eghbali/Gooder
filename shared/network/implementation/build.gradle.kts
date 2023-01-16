import org.gradle.api.internal.artifacts.dependencies.DefaultExternalModuleDependency

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.kapt)
}

kotlin {
    android()
    ios()
    iosSimulatorArm64()

    ios {
        binaries.framework {
            baseName = "network"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(projects.shared.network.api)
                implementation(projects.shared.coreDi)

                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.content.negotiation)
                implementation(libs.ktor.client.logging)
                implementation(libs.ktor.serialization.kotlinx.json)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(libs.hilt.library)
                implementation(libs.ktor.client.android)
                implementation(libs.ktor.client.core.jvm)
                implementation(libs.ktor.client.okhttp)
                implementation(libs.ktor.serialization.kotlinx.json.jvm)

                configurations["kapt"].dependencies.add(
                    DefaultExternalModuleDependency("com.google.dagger", "hilt-compiler", libs.versions.dagger.get())
                )
            }
        }
        val androidTest by getting
        val iosSimulatorArm64Main by getting
        val iosMain by getting {
            dependsOn(commonMain)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                implementation(libs.ktor.client.ios)
            }
        }
        val iosSimulatorArm64Test by getting
        val iosTest by getting {
            dependsOn(commonTest)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = "gooder.shared.network"
}
