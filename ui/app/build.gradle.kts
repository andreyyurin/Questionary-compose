plugins {
    appPlugins()
}

apply {
    from("$rootDir/etc/signFile.gradle")
}

android {
    appConfiguration()

    kotlinOptions {
        jvmTarget = "1.8"
    }

    hilt {
        enableAggregatingTask = false
    }
}

dependencies {
    implementation(project(":ui:login"))
    implementation(project(":ui:onboarding"))

    baseUiDependencies()
}
