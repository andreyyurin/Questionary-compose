package ru.sad.questionary.ui.navigation

import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ru.sad.base.base.navigation.BottomTabs
import ru.sad.base.theme.BlueC1D0FF
import ru.sad.base.theme.RedFF512FPinkDD2476
import ru.sad.base.theme.WhiteFDFDFFGrayEEF2FF

@Composable
@Preview
fun BottomNavigation(navController: NavController = rememberNavController()) {
    val items = BottomTabs.entries
    val navBackStackEntry by navController.currentBackStackEntryAsState()
  //  val systemUiController = rememberSystemUiController()
    val currentRoute = navBackStackEntry?.destination?.route
    val showBottomBar = remember { mutableStateOf(false) }
    val isLightStatusBar = remember { mutableStateOf(true) }

}