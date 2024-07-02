package com.exmaple.newsapp.presentation.ui.screens.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.exmaple.newsapp.domain.model.NewsData
import kotlinx.coroutines.launch
import com.exmaple.newsapp.domain.usecase.ResultState
import org.koin.compose.koinInject
import com.exmaple.newsapp.presentation.ui.components.ErrorBox
import com.exmaple.newsapp.presentation.ui.components.LoadingBox
import com.exmaple.newsapp.presentation.ui.components.NewsCard
import com.exmaple.newsapp.presentation.ui.components.TopAppBarWithProfile
import com.exmaple.newsapp.presentation.ui.navigation.screen.BottomNavItemScreen
import com.exmaple.newsapp.presentation.viewmodels.MainViewModel
import com.exmaple.newsapp.theme.LocalThemeIsDark
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.text.font.FontWeight

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier, navController: NavHostController) {

    val viewModel: MainViewModel = koinInject()
    var aricles by remember { mutableStateOf<NewsData?>(null) }
//    val refreshScope = rememberCoroutineScope()
//    var refreshing by remember { mutableStateOf(false) }
//    fun refresh() {
//        refreshScope.launch {
//            viewModel.getNewsData()
//            refreshing = false
//        }
//    }

    val isLoading = remember { mutableStateOf(true) }

//    val refreshState = rememberPullRefreshState(refreshing, ::refresh)

    val windowClass = calculateWindowSizeClass()
    val showNavigationRail = windowClass.widthSizeClass != WindowWidthSizeClass.Compact


    LaunchedEffect(Unit) {
        viewModel.getNewsData()
    }
    val state by viewModel.newsData.collectAsState()

    when (state) {
        is ResultState.Error -> {
            isLoading.value = false
            val error = (state as ResultState.Error).error
            ErrorBox(error)
        }

        is ResultState.Loading -> {
            isLoading.value = true
            LoadingBox()
        }

        is ResultState.Success -> {
            isLoading.value = false
            val response = (state as ResultState.Success).response
            aricles = response
        }
    }

    val options = listOf(
        "All",
        "technology",
        "business",
        "entertainment",
        "general",
        "health",
        "science",
        "sports",
    )
    var selectedOption by remember { mutableStateOf("All") }

    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        topBar = {
            TopAppBarWithProfile(
                name = "Roshan",
                onCartClicked = {
                },
                profileImageUrl = "",
                itemCount = 0,
                onProfileClick = {
                }
            )
        }
    ) {
        Box(
            Modifier
                .padding(top = 70.dp, bottom = 50.dp)
        ) {


            LazyRow(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(options) { op ->
                    OptionText(text = op, isSelected = op == selectedOption) {
                        selectedOption = op
                        viewModel.getNewsData(if(op == "All") "" else op)
                    }
                }
            }



            if (isLoading.value) {
                LoadingBox()
            } else {
                if (showNavigationRail) {
                    LazyVerticalGrid(
                        modifier = Modifier.fillMaxWidth().padding(
                            top = it.calculateTopPadding(),
                            bottom = 0.dp,
                            start = 8.dp,
                            end = 8.dp
                        ),
                        columns = GridCells.Adaptive(minSize = 400.dp)
                    ) {
                        aricles?.articles?.forEachIndexed { index, article ->
                            item {
                                NewsCard(article, index, onItemClicked = {
                                    navController.navigate(BottomNavItemScreen.Detail.passDataId(dataId = it))
                                })
                            }
                        }
                    }
                } else {
                    LazyColumn(
                        modifier = Modifier.fillMaxWidth().padding(
                            top = it.calculateTopPadding(),
                            bottom = 0.dp,
                            start = 8.dp,
                            end = 8.dp
                        ),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(0.dp)
                    ) {
                        aricles?.articles?.forEachIndexed { index, article ->
                            item {
                                NewsCard(article, index, onItemClicked = {
                                    navController.navigate(BottomNavItemScreen.Detail.passDataId(dataId = it))
                                })
                            }
                        }
                    }
                }

            }


        }
    }


}

@Composable
fun OptionText(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    val isDark by LocalThemeIsDark.current
    val backgroundColor = if (isSelected) MaterialTheme.colorScheme.secondaryContainer else Color.Transparent
    val borderColor = if (isSelected) Color.Transparent else MaterialTheme.colorScheme.secondaryContainer
    val textColor = if (isSelected) Color.White else if (isDark) Color.White else Color.Black

    FilledTonalButton(
        onClick = { onClick() },
        modifier = Modifier.clickable { onClick() },
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.filledTonalButtonColors(
            containerColor = backgroundColor,
        ),
        border = BorderStroke(1.dp, borderColor)
    ) {
        Text(
            text = text,
            color = textColor,
            modifier = Modifier.padding(horizontal = 3.dp, vertical = 2.dp)
        )
    }
}