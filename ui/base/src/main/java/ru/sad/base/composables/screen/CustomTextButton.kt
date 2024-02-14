package ru.sad.base.composables.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import ru.sad.base.R

@Composable
fun CustomTextButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    textSize: TextUnit = TextUnit.Unspecified,
    text: String = ""
) {
    val cornerShapeSize = dimensionResource(id = R.dimen.size_40_dp)

    return TextButton(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.main_second_color)),
        contentPadding = PaddingValues(vertical = 16.dp),
        shape = RoundedCornerShape(cornerShapeSize),
        modifier = modifier
            .fillMaxWidth()
    ) {
        BasicText(
            text = text,
            style = TextStyle(
                color = Color.Black,
                fontSize = textSize,
                fontFamily = FontFamily(Font(R.font.gothic))
            )
        )

    }
}