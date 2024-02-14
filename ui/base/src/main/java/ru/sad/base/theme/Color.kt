package ru.sad.base.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color


// Blue colors
val BlueC1D0FF = Color(0xFFC1D0FF)

// White colors
val WhiteFFFFFF = Color(0xFFFFFFFF)
val WhiteEEF3FF = Color(0xFFEEF3FF)
val WhiteEEF2FF = Color(0xFFEEF2FF)
val WhiteF5F5F5 = Color(0xFFF5F5F5)

// Black colors
val Black000B2D = Color(0xFF000B2D)
val BlackCC000B2C = Color(0xCC000B2C)
val Black0C002C = Color(0xFF0C002C)
val Black1C0003 = Color(0xFF1C0003)

// Gray colors
val Gray9AA1B6 = Color(0xFF9AA1B6)
val GrayD8E1FF = Color(0xFFD8E1FF)

// Yellow colors
val YellowFFC530 = Color(0xFFFFC530)

val RedFF512F = Color(0xFFFF512F)
val PinkDD2476 = Color(0xFFDD2476)

// Gradients colors (vertical)
val WhiteFDFDFFGrayEEF2FF = Brush.verticalGradient(
    0f to Color(0xFFFDFDFF),
    0.3646f to Color(0xFFEEF2FF)
)

// Gradients colors (horizontal)
val RedFF512FPinkDD2476 = Brush.horizontalGradient(
    listOf(
        RedFF512F,
        PinkDD2476
    )
)
val PurpleA226CEViolet6626CE = Brush.horizontalGradient(
    listOf(
        Color(0xFFA226CE),
        Color(0xFF6626CE)
    )
)
val YellowFFBE15OrangeFF9315 = Brush.horizontalGradient(
    listOf(
        Color(0xFFFFBE15),
        Color(0xFFFF9315)
    )
)
val Green2ACEC4Green2ABACE = Brush.horizontalGradient(
    listOf(
        Color(0xFF2ACEC4),
        Color(0xFF2ABACE)
    )
)
