plugins {
    basePlugins()
}

android {
    baseConfiguration()

    hilt {
        enableAggregatingTask = false
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    baseDependencies()
}