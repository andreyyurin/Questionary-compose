package ru.sad.login.model

sealed class LoginScreenState {

    data object Loading : LoginScreenState()

    data class Content(
        val name: String = "",
        val password: String = ""
    ) : LoginScreenState()

    data object Error : LoginScreenState()
}
