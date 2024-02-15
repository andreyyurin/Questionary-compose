package ru.sad.login

import android.graphics.Bitmap
import android.icu.text.ListFormatter.Width
import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavHostController
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.sad.base.composables.screen.CustomText
import ru.sad.base.composables.screen.CustomTextButton
import ru.sad.base.composables.screen.CustomTextField
import ru.sad.base.composables.screen.LoadingScreen
import ru.sad.login.model.ChangeLoginField
import ru.sad.login.model.LoginScreenEvent
import ru.sad.login.model.LoginScreenState

@Composable
fun LoginScreenMain(
    navController: NavHostController,
    viewModel: LoginViewModel
) {
    val state = viewModel.state.collectAsState(initial = LoginScreenState.Content())

    when (val stateValue = state.value) {
        LoginScreenState.Loading -> LoadingScreen()
        LoginScreenState.Error -> {

        }

        is LoginScreenState.Content -> LoginScreen(stateValue) {
            viewModel.onEvent(LoginScreenEvent.ChangeFieldValue(it))
        }
    }
}

@Composable
private fun LoginScreen(
    content: LoginScreenState.Content,
    onValueChange: (ChangeLoginField) -> Unit
) {

    ConstraintLayout(
        modifier = Modifier
            .background(colorResource(id = ru.sad.base.R.color.main_background_color))
            .fillMaxSize()
    ) {
        val (imageLogo, textTitle, fieldName, fieldPassword, buttonContinue) = createRefs()

        val marginStartEnd = dimensionResource(id = ru.sad.base.R.dimen.size_16_dp)
        val marginBottom40 = dimensionResource(id = ru.sad.base.R.dimen.size_40_dp)
        val marginBottom20 = dimensionResource(id = ru.sad.base.R.dimen.size_20_dp)
        val marginImage = dimensionResource(id = ru.sad.base.R.dimen.size_20_dp)

        Image(
            painter = painterResource(ru.sad.base.R.drawable.img_logo),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .constrainAs(imageLogo) {
                    top.linkTo(parent.top, marginImage)
                    bottom.linkTo(fieldName.top, marginImage)
                    start.linkTo(
                        parent.start
                    )
                    end.linkTo(
                        parent.end
                    )
                    height = Dimension.fillToConstraints
                }
                .fillMaxWidth(),
        )

        CustomText(
            weight = FontWeight.ExtraBold,
            text = stringResource(id = R.string.login_title),
            textSize = dimensionResource(id = ru.sad.base.R.dimen.size_20_sp).value.sp,
            modifier = Modifier.constrainAs(textTitle) {
                bottom.linkTo(fieldName.top, margin = marginBottom20)
                start.linkTo(
                    parent.start,
                    margin = marginStartEnd
                )
                end.linkTo(
                    parent.end,
                    margin = marginStartEnd
                )
            }
        )

        CustomTextField(
            startValue = content.name,
            onValueChange = { onValueChange.invoke(ChangeLoginField.Name(it)) },
            modifier = Modifier
                .constrainAs(fieldName) {
                    bottom.linkTo(fieldPassword.top, marginBottom20)
                    start.linkTo(
                        parent.start,
                        margin = marginStartEnd
                    )
                    end.linkTo(
                        parent.end,
                        margin = marginStartEnd
                    )
                    width = Dimension.fillToConstraints
                },
            hint = stringResource(id = R.string.login_et_name_hint)
        )

        CustomTextField(
            startValue = content.password,
            onValueChange = { onValueChange.invoke(ChangeLoginField.Password(it)) },
            modifier = Modifier.constrainAs(fieldPassword) {
                bottom.linkTo(buttonContinue.top, marginBottom20)
                start.linkTo(
                    parent.start,
                    margin = marginStartEnd
                )
                end.linkTo(
                    parent.end,
                    margin = marginStartEnd
                )
                width = Dimension.fillToConstraints
            },
            hint = stringResource(id = R.string.login_et_password_hint),
            visualTransformation = PasswordVisualTransformation()
        )

        CustomTextButton(
            onClick = { /*TODO*/ },
            text = stringResource(id = R.string.login_btn_enter),
            textSize = dimensionResource(id = ru.sad.base.R.dimen.size_14_sp).value.sp,
            modifier = Modifier
                .constrainAs(
                    buttonContinue
                ) {
                    bottom.linkTo(parent.bottom, marginBottom40)
                    start.linkTo(
                        parent.start,
                        margin = marginStartEnd
                    )
                    end.linkTo(
                        parent.end,
                        margin = marginStartEnd
                    )
                    width = Dimension.fillToConstraints
                }
        )

        CustomTextButton(
            onClick = { /*TODO*/ },
            text = stringResource(id = R.string.login_btn_enter),
            textSize = dimensionResource(id = ru.sad.base.R.dimen.size_14_sp).value.sp,
            modifier = Modifier
                .constrainAs(
                    buttonContinue
                ) {
                    bottom.linkTo(parent.bottom, marginBottom40)
                    start.linkTo(
                        parent.start,
                        margin = marginStartEnd
                    )
                    end.linkTo(
                        parent.end,
                        margin = marginStartEnd
                    )
                    width = Dimension.fillToConstraints
                }
        )
    }
}