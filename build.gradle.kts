//import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    kotlin("multiplatform") version "1.6.10"
    id("maven-publish")
//    id("com.android.library")
//    id("io.github.gradle-nexus.publish-plugin")
//    id("signing")
}

group = "com.blackstone"
version = "0.1.0"


repositories {
    mavenCentral()
    google()
    mavenLocal()
}


//android {
//    compileSdkVersion(29)
//    defaultConfig {
//        minSdkVersion(15)
//    }
//
//    compileOptions {
//        sourceCompatibility = JavaVersion.VERSION_1_8
//        targetCompatibility = JavaVersion.VERSION_1_8
//    }
//}



kotlin {
    jvm()

    // I don't think this is needed because we don't have any resource dependencies like images and such
//    android {
//        publishLibraryVariants("release", "debug")
//    }

    js()
    watchosSimulatorArm64()
    watchos()

    val iosArm32 = iosArm32()
    val iosArm64 = iosArm64()
    val iosX64 = iosX64()
    val iosSimulatorArm64 = iosSimulatorArm64()

    sourceSets {

        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
                api("co.touchlab:stately-common:1.1.7")
                api("co.touchlab:stately-concurrency:1.2.1")
            }
            }

        val jvmMain by getting {
            dependencies {
                implementation(kotlin("stdlib-jdk8"))
            }
        }

    }
}



publishing {
    // this fetches our credentials from ~/.gradle/gradle.properties
    val mavenUser: String by project
    val mavenPassword: String by project
//
//    repositories {
//        maven {
//            setUrl("https://repos.awhb.dev/releases")
//            authentication {
//                create("basic", BasicAuthentication::class.java)
//            }
//            credentials {
//                username = mavenUser
//                password = mavenPassword
//            }
//        }
//    }
}

