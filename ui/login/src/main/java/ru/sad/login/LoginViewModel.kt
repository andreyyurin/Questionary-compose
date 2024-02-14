package ru.sad.login

import android.util.Log
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.sad.base.base.BaseViewModel
import ru.sad.login.model.ChangeLoginField
import ru.sad.login.model.LoginScreenAction
import ru.sad.login.model.LoginScreenDialogState
import ru.sad.login.model.LoginScreenEvent
import ru.sad.login.model.LoginScreenState
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() :
    BaseViewModel<LoginScreenState, LoginScreenDialogState, LoginScreenEvent, LoginScreenAction>() {

    init {
        setState(LoginScreenState.Content())
    }

    override fun onEvent(event: LoginScreenEvent) {
        when (event) {
            LoginScreenEvent.Start -> setState(LoginScreenState.Content())
            LoginScreenEvent.ClickLogin -> login()
            is LoginScreenEvent.ChangeFieldValue -> handleChangeFieldValue(event.field)
        }
    }

    private fun handleChangeFieldValue(field: ChangeLoginField) {
        val state = getStateValueOrNull()
        if (state !is LoginScreenState.Content) return

        setState(
            with(state) {
                when (field) {
                    is ChangeLoginField.Name -> {
                        copy(name = field.value)
                    }

                    is ChangeLoginField.Password -> {
                        copy(password = field.value)
                    }
                }
            }
        )
    }

    private fun login() {
        setState(LoginScreenState.Content())
    }
}