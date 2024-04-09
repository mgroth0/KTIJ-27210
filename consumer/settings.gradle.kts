pluginManagement {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
        maven {
            url = file("../plugin/build/bug/repo").toURI()
        }
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.toString() == "bug.plugin") {
                useModule("bug:gradlePlugin:1")
            }
        }
    }
}
plugins {
    id("bug.plugin")
}
