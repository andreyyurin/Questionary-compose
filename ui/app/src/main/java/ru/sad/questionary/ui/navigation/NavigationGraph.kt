package ru.sad.questionary.ui.navigation

import android.util.Base64
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.sad.base.base.navigation.LOGIN_SCREEN_ROUTE
import ru.sad.login.LoginScreenMain
import ru.sad.login.LoginViewModel

@Composable
fun NavigationGraph(navController: NavHostController, modifier: Modifier) {
    NavHost(navController, startDestination = LOGIN_SCREEN_ROUTE, modifier = modifier) {

        composable(LOGIN_SCREEN_ROUTE) {
            val loginViewModel = hiltViewModel<LoginViewModel>()
            LoginScreenMain(navController = navController, loginViewModel)
        }
    }
}