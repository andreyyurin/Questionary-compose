package ru.sad.login.model

sealed class LoginScreenEvent {

    data object Start: LoginScreenEvent()

    data object ClickLogin: LoginScreenEvent()

    data class ChangeFieldValue(
        val field: ChangeLoginField
    ): LoginScreenEvent()
}