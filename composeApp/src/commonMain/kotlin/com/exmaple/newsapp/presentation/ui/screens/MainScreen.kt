package com.exmaple.newsapp.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.exmaple.newsapp.presentation.ui.navigation.graph.MainNavGraph
import com.exmaple.newsapp.presentation.ui.navigation.screen.BottomBar
import com.exmaple.newsapp.presentation.ui.navigation.screen.NavigationSideBar


@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun MainScreen(
    navController: NavHostController = rememberNavController()
) {
    val windowClass = calculateWindowSizeClass()
    val showNavigationRail = windowClass.widthSizeClass != WindowWidthSizeClass.Compact
    var isTitleVisible by remember { mutableStateOf(false) }
    var width = 80.dp
    if (isTitleVisible) {
        width = 200.dp
    }
    Scaffold(
        bottomBar = {
            if (!showNavigationRail) {
                BottomBar(navController = navController)
            }
        },
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
                .navigationBarsPadding()
                .padding(
                    top = it.calculateTopPadding(),
                    start = if (showNavigationRail) width else 0.dp
                )
        ) {
            MainNavGraph(navController = navController)
        }
    }
    if (showNavigationRail) {
        NavigationSideBar(navController = navController, onClickMenu = { isTitleVisible = !isTitleVisible })
    }


}