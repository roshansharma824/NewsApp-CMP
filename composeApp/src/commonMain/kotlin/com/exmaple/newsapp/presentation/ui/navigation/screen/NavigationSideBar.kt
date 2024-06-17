package com.exmaple.newsapp.presentation.ui.navigation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
    onClickMenu: () -> Unit
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
            modifier = Modifier.background(color = MaterialTheme.colorScheme.surfaceContainerLowest),
            containerColor = MaterialTheme.colorScheme.surfaceContainerLowest,
            header = {
                IconButton(onClick = {
                    isTitleVisible = !isTitleVisible
                    onClickMenu.invoke()
                },
                    modifier = Modifier.align(Alignment.Start).padding(16.dp)
                ) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                }
            },
        ) {
            Column(
                modifier = Modifier.fillMaxHeight().width(if (isTitleVisible) 200.dp else 80.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically)
            ) {
                navigationItems.forEachIndexed { index, item ->
                    Row(
                        modifier = Modifier.padding(horizontal = 16.dp)
                            .fillMaxWidth()
                            .background(color = if (currentRoute == item.route) MaterialTheme.colorScheme.surfaceContainer else MaterialTheme.colorScheme.surfaceContainerLowest, shape = RoundedCornerShape(10.dp)),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        NavigationRailItem(
                            selected = false,
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
                                AnimatedVisibility(!isTitleVisible) {
                                    Text(
                                        text = item.title,
                                        fontSize = MaterialTheme.typography.labelSmall.fontSize,
                                        color = if (currentRoute == item.route) primaryLight else if (isDark) secondaryLight else onSurfaceVariantLight
                                    )
                                }
                            }
                        )
                        AnimatedVisibility(isTitleVisible) {
                            Text(
                                text = item.title,
                                fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                                color = if (currentRoute == item.route) primaryLight else if (isDark) secondaryLight else onSurfaceVariantLight,
                                modifier = Modifier.padding(bottom = 4.dp)
                            )
                        }
                    }

                }
            }
        }
    }

}