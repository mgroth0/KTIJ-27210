package plugin

import org.gradle.api.Plugin
import org.gradle.api.initialization.Settings


class ApplyPluginsPlugin: Plugin<Settings> {
    override fun apply(target: Settings) {
        target.gradle.rootProject {
            it.plugins.apply("org.jetbrains.kotlin.android")
            it.plugins.apply("com.android.library")
        }
    }
}