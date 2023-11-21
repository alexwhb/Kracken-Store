
plugins {
    kotlin("multiplatform") version "1.9.0"
    id("maven-publish")
}

group = "com.blackstone"
version = "0.3.0"


repositories {
    mavenCentral()
    google()
    mavenLocal()
}

kotlin {
    jvm()

    js(IR) {
        browser { binaries.executable() }
        nodejs { binaries.executable() }
    }
    watchosSimulatorArm64()
    watchos()
    iosArm64()
    iosX64()
    iosSimulatorArm64()

    sourceSets {

        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
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

