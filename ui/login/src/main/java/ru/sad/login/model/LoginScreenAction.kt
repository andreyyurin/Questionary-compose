package ru.sad.login.model

sealed class LoginScreenAction {

    class NavigateTo(
        val route: String
    ) : LoginScreenAction()
}
