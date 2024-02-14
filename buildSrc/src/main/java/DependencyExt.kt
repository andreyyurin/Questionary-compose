import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.implementation(dependency: String) {
    add("implementation", dependency)
}

fun DependencyHandler.implementation(dependency: Dependency) {
    add("implementation", dependency)
}

fun DependencyHandler.test(dependency: String) {
    add("testImplementation", dependency)
}


fun DependencyHandler.androidTest(dependency: Dependency) {
    add("testImplementation", dependency)
}

fun DependencyHandler.androidTest(dependency: String) {
    add("androidTestImplementation", dependency)
}

fun DependencyHandler.debugImplementation(dependency: String) {
    add("debugImplementation", dependency)
}

fun DependencyHandler.kapt(dependency: String) {
    add("kapt", dependency)
}

fun DependencyHandler.ksp(dependency: String) {
    add("ksp", dependency)
}

fun DependencyHandler.api(dependency: Dependency) {
    add("api", dependency)
}

fun DependencyHandler.compileOnly(dependency: String) {
    add("compileOnly", dependency)
}

fun DependencyHandler.compileT(dependency: String) {
    add("compileOnly", dependency)
}
