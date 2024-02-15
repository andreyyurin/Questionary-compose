@file:Suppress("UnstableApiUsage")

include(":ui:onboarding")


pluginManagement {
    plugins {
        id("org.jetbrains.kotlin.android") version "1.9.22" apply false
        id("com.android.library") version "8.2.2"
    }
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "questionary"
include(":ui:app", ":ui:base", ":ui:login", ":ui:onboarding")
include(":domain")
include(":data")
