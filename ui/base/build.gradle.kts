plugins {
    basePlugins()
}

android {
    baseConfiguration()

    hilt {
        enableAggregatingTask = false
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    baseDependencies()
}