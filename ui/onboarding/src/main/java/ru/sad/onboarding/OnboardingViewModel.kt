package ru.sad.onboarding

import dagger.hilt.android.lifecycle.HiltViewModel
import ru.sad.base.base.BaseViewModel
import ru.sad.base.base.navigation.LOGIN_SCREEN_ROUTE
import ru.sad.data.sharedprefs.PrefsRepository
import ru.sad.onboarding.model.OnBoardingScreenPage
import ru.sad.onboarding.model.OnboardingScreenAction
import ru.sad.onboarding.model.OnboardingScreenEvent
import ru.sad.onboarding.model.OnboardingScreenState
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val prefsRepository: PrefsRepository
) : BaseViewModel<OnboardingScreenState, Nothing, OnboardingScreenEvent, OnboardingScreenAction>() {

    init {
        setState(OnboardingScreenState.Content())
        checkIsOnBoardingShown()
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
                prefsRepository.setOnBoardingShown()
                emitAction(OnboardingScreenAction.NavigateTo(LOGIN_SCREEN_ROUTE))
            }

            else -> {
                emitAction(OnboardingScreenAction.NextPage)
            }
        }
    }

    private fun checkIsOnBoardingShown() {
        if(prefsRepository.isOnboardingShown()) {
            emitAction(OnboardingScreenAction.NavigateTo(LOGIN_SCREEN_ROUTE))
        }
    }
}