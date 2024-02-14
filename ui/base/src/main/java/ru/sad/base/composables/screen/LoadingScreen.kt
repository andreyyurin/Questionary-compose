package ru.sad.base.composables.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import ru.sad.base.R
import ru.sad.base.theme.RedFF512F
import ru.sad.base.theme.WhiteFDFDFFGrayEEF2FF

//@Composable
//fun LoadingScreen(
//    modifier: Modifier = Modifier
//) = Box(
//    modifier = modifier
//        .background(
//            brush = WhiteFDFDFFGrayEEF2FF
//        )
//        .fillMaxSize(),
//    contentAlignment = Alignment.Center
//) {
//    CircularProgressIndicator(
//        modifier = Modifier
//            .size(dimensionResource(R.dimen.size_40_dp)),
//        color = RedFF512F,
//        strokeWidth = dimensionResource(R.dimen.size_4_dp)
//    )
//}