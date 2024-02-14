package ru.sad.base.composables.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import ru.sad.base.R

@Composable
fun CustomText(
    text: String,
    modifier: Modifier = Modifier,
    textSize: TextUnit = TextUnit.Unspecified,
    weight: FontWeight = FontWeight.Normal,
    color: Color = Color.Black,
    maxLines: Int = 1
) {
    return BasicText(
        modifier = modifier,
        text = text,
        style = TextStyle(
            fontWeight = weight,
            fontFamily = FontFamily(Font(resId = R.font.gothic, weight = weight)),
            fontSize = textSize,
            color = color
        )
    )
}