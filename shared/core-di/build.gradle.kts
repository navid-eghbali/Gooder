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
            baseName = "core.di"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(libs.kodein.di)
                api(libs.kodein.di.conf)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting
        val androidTest by getting
        val iosSimulatorArm64Main by getting
        val iosMain by getting {
            dependsOn(commonMain)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosSimulatorArm64Test by getting
        val iosTest by getting {
            dependsOn(commonTest)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = "gooder.shared.core.di"
}
