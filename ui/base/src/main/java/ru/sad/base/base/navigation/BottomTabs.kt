package ru.sad.base.base.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import ru.sad.base.R

enum class BottomTabs(
    @StringRes
    val title: Int,
    @DrawableRes
    val icon: Int,
    val route: String,
    val innerRoutes: List<String>
) {
    //GAMES(R.string.bottom_title_home, R.drawable.ic_call_answer, "", listOf("")),
}