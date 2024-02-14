package ru.sad.login.model

sealed class ChangeLoginField(
    val value: String
) {
    class Name(value: String) : ChangeLoginField(value)

    class Password(value: String) : ChangeLoginField(value)
}