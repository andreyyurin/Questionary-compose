plugins {
    baseUiPlugins()
}

android {
    baseUiConfiguration("ru.sad.onboarding")

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    baseUiDependencies()
}