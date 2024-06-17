package com.exmaple.newsapp.presentation.ui.navigation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.exmaple.newsapp.theme.LocalThemeIsDark
import com.exmaple.newsapp.theme.onSurfaceVariantLight
import com.exmaple.newsapp.theme.primaryLight
import com.exmaple.newsapp.theme.secondaryLight

@Composable
fun NavigationSideBar(
    navController: NavController,
) {
    var isTitleVisible by remember { mutableStateOf(false) }
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
        NavigationRail(
            header = {
                IconButton(onClick = {
                    isTitleVisible = !isTitleVisible
                }) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                }
            },
        ) {
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically)
            ) {
                navigationItems.forEachIndexed { index, item ->
                    NavigationRailItem(
                        selected = currentRoute == item.route,
                        onClick = {
                            navController.navigate(item.route) {
                                navController.graph.startDestinationRoute?.let { screen_route ->
                                    popUpTo(screen_route) { saveState = true }
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.title,
                                tint = if (currentRoute == item.route) primaryLight else if (isDark) secondaryLight else onSurfaceVariantLight
                            )
                        },
                        label = {
                            AnimatedVisibility(isTitleVisible) {
                                Text(
                                    text = item.title,
                                    fontSize = MaterialTheme.typography.bodySmall.fontSize
                                )
                            }
                        },
                    )
                }
            }
        }
    }

}

//@Composable
//fun NavigationIcon(
//    item: BottomNavItemScreen, selected: Boolean,
//) {
//    BadgedBox(badge = {
//        if (item.badgeCount != null) {
//            Badge {
//                Text(text = item.badgeCount.toString())
//            }
//        } else if (item.hasNews) {
//            Badge()
//        }
//    }) {
//        Icon(
//            imageVector = if (selected) item.selectedIcon else item.unselectedIcon,
//            contentDescription = item.title
//        )
//    }
//}