@file:Suppress("UnstableApiUsage")

pluginManagement {
    plugins {
        id("org.jetbrains.kotlin.android") version "1.9.22" apply false
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
include(":ui:app", ":ui:base", ":ui:login")
include(":domain")
include(":data")
