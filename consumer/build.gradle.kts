import org.gradle.api.JavaVersion.VERSION_17

plugins {
    kotlin("android")
    id("com.android.library")
}

repositories {
    google()
    mavenCentral()
}

android {
    namespace = "matt.bug"
    compileSdk = 34
    defaultConfig {
        minSdk = 33
    }
    compileOptions {
        sourceCompatibility = VERSION_17
        targetCompatibility = VERSION_17
        kotlinOptions {
            jvmTarget = "17"
        }
    }
}