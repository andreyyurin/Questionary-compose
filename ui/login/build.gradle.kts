plugins {
    baseUiPlugins()
}

android {
    baseUiConfiguration("ru.sad.login")

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    baseUiDependencies()
}