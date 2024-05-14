// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.jetbrains.kotlin.kapt) apply false
}

subprojects {
    tasks.withType<Test> {
        //useJUnitPlatform()
        jvmArgs = jvmArgs!! + listOf("--add-opens=java.base/java.lang=ALL-UNNAMED")
    }
}