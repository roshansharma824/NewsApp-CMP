package com.exmaple.newsapp.presentation.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
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
import com.exmaple.newsapp.presentation.viewmodels.MainViewModel


@Composable
fun HomeScreen(modifier: Modifier = Modifier, navController: NavHostController) {

    val viewModel: MainViewModel = koinInject()
    var newsData by remember { mutableStateOf<NewsData?>(null) }
    val refreshScope = rememberCoroutineScope()
    var refreshing by remember { mutableStateOf(false) }
    fun refresh() {
        refreshScope.launch {
            viewModel.getNewsData()
            refreshing = false
        }
    }
    val isLoading = remember { mutableStateOf(true) }

//    val refreshState = rememberPullRefreshState(refreshing, ::refresh)


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
            newsData = response
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        topBar = {
            TopAppBarWithProfile(
                name = "Roshan",
                onCartClicked = {
//                        cartItemList?.let { carts ->
//                            val mutableCartsList = carts.toMutableList()
//                            navigator?.push(CartList(mutableCartsList))
//                        }
                },
                profileImageUrl = "",
                itemCount = 0,
                onProfileClick = {
//                        if (user?.user?.email?.isEmpty() == true) {
//                            navigator?.push(LoginScreen())
//                        } else {
//                            isProfile = !isProfile
//                        }
                }
            )
        }
    ) {
        Box(
            Modifier
//                .pullRefresh(refreshState),
        ) {

            if (isLoading.value){
                LoadingBox()
            }else {
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
                    newsData?.results?.forEach { item ->
                        item {
                            NewsCard(item, onItemClick = {
//                            navController.navigate("news_details/${item}")
                            })
                        }
                    }
                }
            }


        }
    }


}