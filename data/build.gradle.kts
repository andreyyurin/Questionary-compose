plugins {
    dataPlugins()
}

android {
    dataConfiguration()

    hilt {
        enableAggregatingTask = false
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    dataDependencies()
}