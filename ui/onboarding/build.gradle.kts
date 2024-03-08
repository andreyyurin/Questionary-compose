plugins {
    baseUiPlugins()
}

android {
    baseUiConfiguration("ru.sad.onboarding")

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    baseUiDependencies()
}