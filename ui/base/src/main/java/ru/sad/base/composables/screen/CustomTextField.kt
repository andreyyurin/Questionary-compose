package ru.sad.base.composables.screen

import android.provider.FontsContract.FontFamilyResult
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.sad.base.R
import ru.sad.base.theme.RedFF512F
import ru.sad.base.theme.WhiteFDFDFFGrayEEF2FF

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    startValue: String = "",
    hint: String = "",
    onValueChange: (String) -> Unit,
    singleLine: Boolean = true,
    keyboardType: KeyboardType = KeyboardType.Text,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    val paddingStartEnd = dimensionResource(id = R.dimen.size_20_dp)
    val paddingTopBottom = dimensionResource(id = R.dimen.size_20_dp)
    val cornerShapeSize = dimensionResource(id = R.dimen.size_12_dp)
    val strokeShapeSize = dimensionResource(id = R.dimen.size_1_dp)
    val textSize = dimensionResource(id = R.dimen.size_12_sp).value.sp
    val textSizeHint = dimensionResource(id = R.dimen.size_12_sp).value.sp

    return BasicTextField(
        value = startValue,
        onValueChange = {
            onValueChange.invoke(it)
        },
        decorationBox = { innerTextField ->
            if (startValue.isEmpty()) {
                CustomText(
                    text = hint,
                    textSize = textSizeHint,
                    weight = FontWeight.Normal
                )
            }
            innerTextField()
        },
        visualTransformation = visualTransformation,
        singleLine = singleLine,
        modifier = modifier
            .fillMaxWidth()
            .border(
                BorderStroke(strokeShapeSize, Color.Black),
                RoundedCornerShape(cornerShapeSize)
            )
            .padding(horizontal = paddingStartEnd, vertical = paddingTopBottom)
            .background(Color.Transparent),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        textStyle = TextStyle.Default.copy(
            fontSize = textSize,
            fontFamily = FontFamily(Font(R.font.gothic)),
            fontWeight = FontWeight.Normal
        )
    )
}