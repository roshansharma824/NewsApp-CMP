package com.exmaple.newsapp.presentation.ui.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.exmaple.newsapp.presentation.ui.navigation.screen.BottomNavItemScreen
import com.exmaple.newsapp.presentation.ui.screens.detail.DetailScreen
import com.exmaple.newsapp.presentation.ui.screens.favorite.FavoriteScreen
import com.exmaple.newsapp.presentation.ui.screens.home.HomeScreen
import com.exmaple.newsapp.presentation.ui.screens.profile.ProfileScreen
import com.exmaple.newsapp.presentation.ui.screens.search.SearchScreen


@Composable
fun MainNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.MAIN,
        startDestination = BottomNavItemScreen.Home.route
    ) {
        composable(route = BottomNavItemScreen.Home.route) {
            HomeScreen(navController = navController,)
        }
        composable(route = BottomNavItemScreen.Search.route) {
            SearchScreen()
        }
        composable(route = BottomNavItemScreen.Favorite.route) {
            FavoriteScreen()
        }
        composable(route = BottomNavItemScreen.Profile.route) {
            ProfileScreen()
        }
        composable(route = BottomNavItemScreen.Detail.route, arguments = listOf(navArgument("dataId") {
            type = NavType.StringType
        })) {backStackEntry ->
            val dataId = backStackEntry.arguments?.getString("dataId", "-1")
            if (dataId != null) {
                DetailScreen(navController = navController,dataId = dataId)
            }

        }

    }
}