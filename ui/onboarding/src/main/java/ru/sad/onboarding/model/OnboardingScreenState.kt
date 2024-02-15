package ru.sad.onboarding.model

sealed class OnboardingScreenState {
    data class Content(
        val page: OnBoardingScreenPage = OnBoardingScreenPage.first
    ) : OnboardingScreenState()
}

enum class OnBoardingScreenPage() {
    first,
    second,
    third,
    fourth,
    end
}