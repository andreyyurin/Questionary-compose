package ru.sad.onboarding

import dagger.hilt.android.lifecycle.HiltViewModel
import ru.sad.base.base.BaseViewModel
import ru.sad.onboarding.model.OnBoardingScreenPage
import ru.sad.onboarding.model.OnboardingScreenAction
import ru.sad.onboarding.model.OnboardingScreenEvent
import ru.sad.onboarding.model.OnboardingScreenState
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor() :
    BaseViewModel<OnboardingScreenState, Nothing, OnboardingScreenEvent, OnboardingScreenAction>() {

    init {
        setState(OnboardingScreenState.Content())
    }

    override fun onEvent(event: OnboardingScreenEvent) {
        when (event) {
            OnboardingScreenEvent.Start -> setState(OnboardingScreenState.Content())
            is OnboardingScreenEvent.ClickNext -> handleClickNext(event.nextPage)
        }
    }

    private fun handleClickNext(page: OnBoardingScreenPage) {
        val state = getStateValueOrNull()
        if (state !is OnboardingScreenState.Content) return

        when (page) {
            OnBoardingScreenPage.end -> {
                emitAction(OnboardingScreenAction.NavigateTo(""))
            }

            else -> {
                emitAction(OnboardingScreenAction.NextPage)
            }
        }
    }
}