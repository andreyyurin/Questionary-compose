plugins {
    baseUiPlugins()
}

android {
    baseUiConfiguration("ru.sad.login")

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    baseUiDependencies()
}