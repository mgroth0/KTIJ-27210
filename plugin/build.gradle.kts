

plugins {
    kotlin("jvm") version "2.0.0-Beta5"
    id("java-gradle-plugin")
    id("maven-publish")
}

dependencies {
    compileOnly(gradleApi())
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.0-Beta5")
    implementation("com.android.library:com.android.library.gradle.plugin:8.2.0")
}

repositories {
    mavenCentral()
    google()
}

group = "bug"
version = "1"

publishing {
    repositories {
        maven {
            name = "bugRepo"
            url = layout.buildDirectory.dir("bug").get().dir("repo").asFile.toURI()
        }
    }
    publications {
        create<MavenPublication>("gradlePlugin") {
            groupId = group.toString()
            artifactId = name
            version = version.toString()
            from(components["java"])
        }
    }
}

gradlePlugin {
    plugins {
        create("simplePlugin") {
            id = "bug.plugin"
            implementationClass = "plugin.ApplyPluginsPlugin"
        }
    }
}