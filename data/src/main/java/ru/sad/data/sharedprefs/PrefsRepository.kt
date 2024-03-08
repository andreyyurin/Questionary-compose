package ru.sad.data.sharedprefs

interface PrefsRepository {
    fun isOnboardingShown(): Boolean

    fun setOnBoardingShown()
}