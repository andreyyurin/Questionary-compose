package ru.sad.onboarding.model

sealed class OnboardingScreenEvent {
    data object Start : OnboardingScreenEvent()

    data class ClickNext(val nextPage: OnBoardingScreenPage) : OnboardingScreenEvent()
}