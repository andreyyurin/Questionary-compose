import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.project

fun DependencyHandler.baseUiDependencies() {
    implementation(project(":ui:base"))
    implementation(project(":domain"))
    implementation(project(":data"))

    compose()
    composeMaterial()
    composeConstraint()
    composeNavigation()
    composePaging()
    composeRuntime()
    lottie()
    coroutines()
    hilt()
    tests()
    debug()
}

fun DependencyHandler.baseDependencies() {
    compose()
    composeNavigation()
    composeMaterial()
    composePaging()
    composeRuntime()
    lottie()
    hilt()
    tests()
    debug()
}

fun DependencyHandler.dataDependencies() {
    implementation(project(":domain"))
    retrofit()
    coroutines()
}

fun DependencyHandler.domainDependencies() {
    gson()
}

private fun DependencyHandler.compose() {
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation("androidx.compose:compose-bom:2024.02.00")
    implementation("androidx.compose.ui:ui:1.6.1")
    implementation("androidx.compose.ui:ui-graphics:1.6.1")
    implementation("androidx.compose.ui:ui-tooling-preview:1.6.1")
    implementation("androidx.compose.foundation:foundation:1.6.1")
}

private fun DependencyHandler.composeConstraint() {
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")
}

private fun DependencyHandler.composeRuntime() {
    implementation("androidx.compose.runtime:runtime:1.6.1")
    implementation("androidx.compose.runtime:runtime-livedata:1.6.1")
}

private fun DependencyHandler.lottie() {
    implementation("com.airbnb.android:lottie-compose:5.2.0")
}

private fun DependencyHandler.composePaging() {
    implementation("androidx.paging:paging-compose:3.2.1")
    implementation("androidx.paging:paging-common-ktx:3.2.1")
}

private fun DependencyHandler.composeMaterial() {
    implementation("androidx.compose.material3:material3:1.2.0")
    implementation("androidx.compose.material3:material3-window-size-class:1.2.0")
}

private fun DependencyHandler.composeNavigation() {
    implementation("androidx.navigation:navigation-compose:2.7.6")
}

private fun DependencyHandler.hilt() {
    implementation("com.google.dagger:hilt-android:2.50")
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")
    kapt("com.google.dagger:hilt-android-compiler:2.50")
}

private fun DependencyHandler.tests() {
    test("junit:junit:4.13.2")
    androidTest("androidx.test.ext:junit:1.1.5")
    androidTest("androidx.test.espresso:espresso-core:3.5.1")
    androidTest(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTest("androidx.compose.ui:ui-test-junit4")
}

private fun DependencyHandler.debug() {
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}

private fun DependencyHandler.retrofit() {
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.retrofit2:adapter-rxjava2:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")
}

private fun DependencyHandler.coroutines() {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
}

private fun DependencyHandler.gson() {
    implementation("com.chibatching.kotpref:kotpref:2.13.2")
    implementation("com.chibatching.kotpref:enum-support:2.9.1")
    implementation("com.chibatching.kotpref:gson-support:2.9.2")
    implementation("com.google.code.gson:gson:2.10.1")
}