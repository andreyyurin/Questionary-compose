import com.android.build.gradle.LibraryExtension
import org.gradle.kotlin.dsl.PluginDependenciesSpecScope

private const val NAMESPACE = "ru.sad.domain"

fun LibraryExtension.domainConfiguration() {
    this.namespace = NAMESPACE
    this.compileSdk = Config.CONFIG_COMPILE_SDK
}

fun PluginDependenciesSpecScope.domainPlugins() {
    id(Plugins.LIBRARY)
    id(Plugins.KOTLIN_ANDROID)
}