package com.exmaple.newsapp.presentation.ui.navigation.screen


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import coil3.compose.AsyncImagePainter.State.Empty.painter
import com.exmaple.newsapp.theme.LocalThemeIsDark
import com.exmaple.newsapp.theme.onSurfaceVariantLight
import com.exmaple.newsapp.theme.primaryLight
import com.exmaple.newsapp.theme.secondaryLight
import org.jetbrains.compose.resources.painterResource

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    val navigationItems = listOf(
        BottomNavItemScreen.Home,
        BottomNavItemScreen.Search,
        BottomNavItemScreen.Favorite,
        BottomNavItemScreen.Profile,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val bottomBarDestination = navigationItems.any { it.route == currentRoute }

    val isDark by LocalThemeIsDark.current

    if (bottomBarDestination) {

        Row(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.surfaceContainerLowest)
                .fillMaxHeight(0.08f)
                .fillMaxWidth(),

            horizontalArrangement = Arrangement.SpaceAround
        ) {
            navigationItems.forEach { item ->
                Column(
                    verticalArrangement = Arrangement.Center
                ) {
                    IconButton(
                        modifier = Modifier
                            .height(30.dp),
                        onClick = {
                        navController.navigate(item.route) {
                            navController.graph.startDestinationRoute?.let { screen_route ->
                                popUpTo(screen_route) { saveState = true }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },) {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title,
                            tint = if (currentRoute == item.route) primaryLight else if (isDark) secondaryLight else onSurfaceVariantLight
                        )

                    }

                    Text(
                        modifier = Modifier.padding(bottom = 8.dp),
                        text = item.title,
                        fontWeight = FontWeight.Normal,
                        color = if (currentRoute == item.route) {
                            primaryLight
                        } else onSurfaceVariantLight
                    )

                }



            }
        }
    }
}