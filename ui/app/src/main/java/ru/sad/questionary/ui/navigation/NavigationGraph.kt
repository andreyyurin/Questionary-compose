package ru.sad.questionary.ui.navigation

import android.util.Base64
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.sad.base.base.navigation.LOGIN_SCREEN_ROUTE
import ru.sad.base.base.navigation.ONBOARDING_SCREEN_ROUTE
import ru.sad.login.LoginScreenMain
import ru.sad.login.LoginViewModel
import ru.sad.onboarding.OnboardingScreenMain
import ru.sad.onboarding.OnboardingViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NavigationGraph(navController: NavHostController, modifier: Modifier) {
    NavHost(navController, startDestination = ONBOARDING_SCREEN_ROUTE, modifier = modifier) {

        composable(LOGIN_SCREEN_ROUTE) {
            val loginViewModel = hiltViewModel<LoginViewModel>()
            LoginScreenMain(navController = navController, loginViewModel)
        }

        composable(ONBOARDING_SCREEN_ROUTE) {
            val onboardingViewModel = hiltViewModel<OnboardingViewModel>()
            OnboardingScreenMain(navController = navController, viewModel = onboardingViewModel)
        }
    }
}