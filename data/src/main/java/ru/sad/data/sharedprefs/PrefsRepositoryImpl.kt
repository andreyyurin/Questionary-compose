package ru.sad.data.sharedprefs

import com.chibatching.kotpref.KotprefModel
import javax.inject.Inject

class PrefsRepositoryImpl @Inject constructor() : PrefsRepository {

    private val prefs = object : KotprefModel() {
        var onboardingShown by booleanPref(default = false)
    }

    override fun isOnboardingShown(): Boolean = prefs.onboardingShown

    override fun setOnBoardingShown() {
        prefs.onboardingShown = true
    }
}