import com.android.build.api.dsl.ApplicationBaseFlavor
import com.android.build.api.dsl.ApplicationBuildType
import com.android.build.api.dsl.ApplicationDefaultConfig
import com.android.build.api.dsl.BaseFlavor
import com.android.build.api.dsl.BuildType
import com.android.build.api.dsl.LibraryDefaultConfig
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.ProguardFiles.getDefaultProguardFile
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.android.build.gradle.internal.dsl.DefaultConfig
import org.gradle.api.JavaVersion
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.kotlin.dsl.PluginDependenciesSpecScope

private const val NAMESPACE = "ru.sad.questionary"
private const val TEST_RUNNER = "androidx.test.runner.AndroidJUnitRunner"
private const val KEY_APP_NAME = "app_name"
private const val VALUE_APP_NAME_DEBUG = "Questionary (DEV)"
private const val VALUE_APP_NAME_RELEASE = "Questionary"
private const val APPLICATION_DEBUG_SUFFIX = ".dev"
private const val APPLICATION_DEBUG_NAME_SUFFIX = "-dev"

fun PluginDependenciesSpecScope.appPlugins() {
    id(Plugins.APPLICATION)
    id(Plugins.KOTLIN_ANDROID)
    id(Plugins.HILT)
    id(Plugins.KOTLIN_KAPT)
    id(Plugins.GOOGLE_SERVICES)
}

fun BaseAppModuleExtension.appConfiguration() {
    namespace = NAMESPACE
    compileSdk = Config.CONFIG_COMPILE_SDK

    defaultConfig {
        defaultAppConfig()
    }

    buildTypes {
        debug {
            buildDebugType()
        }
        release {
            buildReleaseType()
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.9"
    }

    packaging {
        resources {
            excludes += "META-INF/"
            excludes += "okhttp3/"
            excludes += "kotlin/"
            excludes += "org/"
            excludes += ".properties"
            excludes += ".bin"
        }
    }
}

private fun ApplicationDefaultConfig.defaultAppConfig() {
    applicationId = NAMESPACE
    minSdk = Config.CONFIG_MIN_SDK
    targetSdk = Config.CONFIG_TARGET_SDK
    versionCode = Config.VERSION_CODE
    versionName = Config.VERSION_NAME

    testInstrumentationRunner = TEST_RUNNER
    vectorDrawables {
        useSupportLibrary = true
    }
}


private fun ApplicationBuildType.buildDebugType() {
    isDebuggable = true

    applicationIdSuffix = APPLICATION_DEBUG_SUFFIX
    versionNameSuffix = APPLICATION_DEBUG_NAME_SUFFIX

    resValue("string", KEY_APP_NAME, VALUE_APP_NAME_DEBUG)
}

private fun ApplicationBuildType.buildReleaseType() {
    isMinifyEnabled = false
    isDebuggable = false

    isShrinkResources = false

    resValue("string", KEY_APP_NAME, VALUE_APP_NAME_RELEASE)
}

