package presentation.ui.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import domain.model.NewsData
import org.flexi.app.domain.usecase.ResultState
import org.koin.compose.koinInject
import presentation.ui.components.ErrorBox
import presentation.ui.components.LoadingBox
import presentation.ui.components.NewsCard
import presentation.viewmodels.MainViewModel

class HomeScreen : Screen {

    @OptIn(
        ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class,
        ExperimentalFoundationApi::class
    )
    @Composable
    override fun Content() {
        val viewModel: MainViewModel = koinInject()
        var newsData by remember { mutableStateOf<NewsData?>(null) }

        LaunchedEffect(Unit) {
            viewModel.getNewsData()
        }
        val state by viewModel.newsData.collectAsState()

        when (state) {
            is ResultState.Error -> {
                val error = (state as ResultState.Error).error
                ErrorBox(error)
            }

            is ResultState.Loading -> {
                LoadingBox()
            }

            is ResultState.Success -> {
                val response = (state as ResultState.Success).response
                newsData = response
            }
        }

        LazyColumn(
            modifier = Modifier.fillMaxWidth().windowInsetsPadding(WindowInsets.ime).padding(8.dp),
//            contentPadding = PaddingValues(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(0.dp)
        ) {
            newsData?.results?.forEach { item ->
                item {
                   NewsCard(item)
                }
            }


        }

    }

}