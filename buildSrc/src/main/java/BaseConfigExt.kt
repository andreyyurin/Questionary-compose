import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.kotlin.dsl.PluginDependenciesSpecScope

private const val NAMESPACE = "ru.sad.base"

fun PluginDependenciesSpecScope.basePlugins() {
    id(Plugins.LIBRARY)
    id(Plugins.KOTLIN_ANDROID)
    id(Plugins.HILT)
    id(Plugins.KOTLIN_KAPT)
}

fun LibraryExtension.baseConfiguration() {
    namespace = NAMESPACE
    compileSdk = Config.CONFIG_COMPILE_SDK

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.9"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

fun LibraryExtension.baseUiConfiguration(name: String) {
    namespace = name
    compileSdk = Config.CONFIG_COMPILE_SDK

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.9"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

fun PluginDependenciesSpecScope.baseUiPlugins() {
    id(Plugins.LIBRARY)
    id(Plugins.KOTLIN_ANDROID)
    id(Plugins.KOTLIN_KAPT)
}