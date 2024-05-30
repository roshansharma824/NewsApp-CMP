import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.ui.navigation.rails.items.NavigationItem
import presentation.ui.navigation.rails.navbar.NavigationSideBar
import presentation.ui.navigation.tabs.favourite.FavouriteTab
import presentation.ui.navigation.tabs.home.HomeTab
import presentation.ui.navigation.tabs.orders.Search
import presentation.ui.navigation.tabs.profile.ProfileTab
import theme.AppTheme
import theme.LocalThemeIsDark
import theme.onSurfaceVariantDark
import theme.onSurfaceVariantLight
import theme.primaryLight
import theme.scrimDark
import theme.secondaryLight
import theme.surfaceBrightDark
import theme.surfaceBrightLight

@Composable
@Preview
fun App() {
    AppTheme {
        AppContent()
    }
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun AppContent() {
    val items = listOf(
        NavigationItem(
            title = "Home",
            selectedIcon = Icons.Default.Home,
            unselectedIcon = Icons.Outlined.Home,
            hasNews = false
        ),
        NavigationItem(
            title = "Search",
            selectedIcon = Icons.Default.Search,
            unselectedIcon = Icons.Outlined.Search,
            hasNews = false,
        ),
        NavigationItem(
            title = "Favourite",
            selectedIcon = Icons.Default.Favorite,
            unselectedIcon = Icons.Outlined.Favorite,
            hasNews = false,
        ),
        NavigationItem(
            title = "My Profile",
            selectedIcon = Icons.Default.Person,
            unselectedIcon = Icons.Outlined.Person,
            hasNews = false,
        ),
    )
    val windowClass = calculateWindowSizeClass()
    val showNavigationRail = windowClass.widthSizeClass != WindowWidthSizeClass.Compact
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    TabNavigator(HomeTab) { tabNavigator ->
        Scaffold(modifier = Modifier.fillMaxWidth(),
            bottomBar = {
                if (!showNavigationRail) {
                    BottomNavigation(
                        modifier = Modifier.fillMaxWidth().windowInsetsPadding(WindowInsets.ime),
                        backgroundColor = androidx.compose.material3.MaterialTheme.colorScheme.background,
                        contentColor = contentColorFor(Color.Red),
                        elevation = 8.dp
                    ) {
                        TabItem(HomeTab)
                        TabItem(Search)
                        TabItem(FavouriteTab)
                        TabItem(ProfileTab)
                    }
                }
            }) {
            Column(
                modifier = Modifier.fillMaxSize()
                    .navigationBarsPadding()
                    .padding(
                        top = it.calculateTopPadding(),
                        start = if (showNavigationRail) 80.dp else 0.dp
                    )
            ) {
                CurrentTab()
            }
        }
    }
    if (showNavigationRail) {
        NavigationSideBar(
            items = items,
            selectedItemIndex = selectedItemIndex,
            onNavigate = {
                selectedItemIndex = it
            }
        )

        Box(
            modifier = Modifier.fillMaxSize()
                .padding(start = 80.dp)
        ) {
            when (selectedItemIndex) {
                0 -> {

                }

                1 -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(androidx.compose.material3.MaterialTheme.colorScheme.background)
                    ) {
                        TabNavigator(Search)
                    }
                }

                2 -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(androidx.compose.material3.MaterialTheme.colorScheme.background)
                    ) {
                        TabNavigator(FavouriteTab)
                    }
                }

                3 -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(androidx.compose.material3.MaterialTheme.colorScheme.background)
                    ) {
                        TabNavigator(ProfileTab)
                    }
                }
            }
        }

    }
}

@Composable
fun RowScope.TabItem(tab: Tab) {
    val isDark by LocalThemeIsDark.current
    val tabNavigator = LocalTabNavigator.current
    NavigationBarItem(
        modifier = Modifier.fillMaxWidth()
            .background(MaterialTheme.colorScheme.surfaceContainerLowest)
            .height(58.dp).clip(RoundedCornerShape(16.dp)),
        selected = tabNavigator.current == tab,
        onClick = {
            tabNavigator.current = tab
        },
        icon = {
            tab.options.icon?.let { painter ->
                Icon(
                    painter,
                    contentDescription = tab.options.title,
                    tint = if (tabNavigator.current == tab) primaryLight else if (isDark) secondaryLight else onSurfaceVariantLight
                )
            }
        },
        label = {
            tab.options.title.let { title ->
                androidx.compose.material3.Text(
                    title,
                    fontSize = 12.sp,
                    color = if (tabNavigator.current == tab) primaryLight else if (isDark) secondaryLight else onSurfaceVariantDark
                )
            }
        },
        enabled = true,
        alwaysShowLabel = true,
        interactionSource = MutableInteractionSource(),
        colors = NavigationBarItemColors(
            selectedTextColor = Color.Red,
            selectedIconColor = Color.Red,
            unselectedTextColor = Color.Red,
            unselectedIconColor = Color.Red,
            selectedIndicatorColor = Color.Transparent,
            disabledIconColor = Color.Red,
            disabledTextColor = Color.Red
        )
    )
}