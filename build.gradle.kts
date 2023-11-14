
plugins {
    kotlin("multiplatform") version "1.9.0"
    id("maven-publish")
}

group = "com.blackstone"
version = "0.2.0"


repositories {
    mavenCentral()
    google()
    mavenLocal()
}



kotlin {
    jvm()

    // I don't think this is needed because we don't have any resource dependencies like images and such
//    android {
//        publishLibraryVariants("release", "debug")
//    }

    js(IR) {
        browser { binaries.executable() }
        nodejs { binaries.executable() }
    }
    watchosSimulatorArm64()
    watchos()
    iosArm64()
    iosX64()
    iosSimulatorArm64()
//    configure(listOf(iosArm64, iosX64, iosSimulatorArm64, watchOsSim, watchOS)) {
//        binaries.framework {
//            baseName = "Kracken"
//        }
//    }

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

    repositories {
        maven {
            name = "reposiliteRepositoryReleases"
            setUrl("https://repos.awhb.dev/releases")
            authentication {
                create("basic", BasicAuthentication::class.java)
            }
            credentials {
                username = mavenUser
                password = mavenPassword
            }
        }
    }
}

