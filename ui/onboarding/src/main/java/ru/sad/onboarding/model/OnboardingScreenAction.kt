package ru.sad.onboarding.model

sealed class OnboardingScreenAction {

    class NavigateTo(
        val route: String
    ) : OnboardingScreenAction()

    data object NextPage : OnboardingScreenAction()
}
