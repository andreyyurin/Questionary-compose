import com.android.build.gradle.LibraryExtension
import org.gradle.kotlin.dsl.PluginDependenciesSpecScope

private const val NAMESPACE = "ru.sad.data"

fun LibraryExtension.dataConfiguration() {
    namespace = NAMESPACE
    compileSdk = Config.CONFIG_COMPILE_SDK
}

fun PluginDependenciesSpecScope.dataPlugins() {
    id(Plugins.LIBRARY)
    id(Plugins.KOTLIN_ANDROID)
}