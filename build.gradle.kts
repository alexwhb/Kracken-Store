//import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    kotlin("multiplatform") version "1.5.30"
    id("maven-publish")
    id("com.android.library")
//    id("io.github.gradle-nexus.publish-plugin")
//    id("signing")
}

group = "com.blackstone"
version = "1.0.0"


repositories {
    mavenCentral()
    google()
    mavenLocal()
}


android {
    compileSdkVersion(29)
    defaultConfig {
        minSdkVersion(15)
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}



kotlin {
    jvm()

    android {
        publishLibraryVariants("release", "debug")
    }

    iosArm32() {
        binaries {
            framework()
        }
    }
    iosArm64() {
        binaries {
            framework()
        }
    }
    iosX64() {
        binaries {
            framework()
        }
    }

    sourceSets {

        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
                api("co.touchlab:stately-common:1.1.7")
                api("co.touchlab:stately-concurrency:1.1.7")
            }
            }

        val jvmMain by getting {
            dependencies {
//                implementation(kotlin("stdlib", KotlinCompilerVersion.VERSION))
                implementation(kotlin("stdlib-jdk8"))
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(kotlin("stdlib-jdk8"))
            }
        }

//        named("nativeMain") {
//            dependsOn(commonMain)
//        }
//
//        named("iosArm64Main") {
//            dependsOn(getAt("nativeMain"))
//        }
//
//        named("iosArm32Main") {
//            dependsOn(getAt("nativeMain"))
//        }
//
//        named("iosX64Main") {
//            dependsOn(getAt("nativeMain"))
//        }
    }
}

//afterEvaluate {
//    project.publishing.publications.all {
//        groupId = group
//        if (it.name.contains("metadata")) {
//            artifactId = "$libraryName"
//        } else {
//            artifactId = "$libraryName-$name"
//        }
//    }
//}

//apply(from = rootProject.file("pom.gradle"))
//apply(from = rootProject.file("gradle/publish.gradle"))
//apply(from = rootProject.file("gradle/nexus.gradle"))
