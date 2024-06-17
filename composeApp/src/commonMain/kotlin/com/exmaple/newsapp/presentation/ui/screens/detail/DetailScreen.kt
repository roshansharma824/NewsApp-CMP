package com.exmaple.newsapp.presentation.ui.screens.detail

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.exmaple.newsapp.domain.model.Article
import com.exmaple.newsapp.domain.model.NewsData
import com.exmaple.newsapp.domain.usecase.ResultState
import com.exmaple.newsapp.presentation.ui.components.ErrorBox
import com.exmaple.newsapp.presentation.ui.components.LoadingBox
import com.exmaple.newsapp.presentation.viewmodels.MainViewModel
import com.exmaple.newsapp.utils.formatDateString
import com.exmaple.newsapp.utils.toCapitalize
import news_app.composeapp.generated.resources.Res
import news_app.composeapp.generated.resources.error_404
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject

@Composable
fun DetailScreen(modifier: Modifier = Modifier, navController: NavHostController, dataId: Int) {
    val viewModel: MainViewModel = koinInject()
    val scrollState = rememberScrollState()
    var article by remember { mutableStateOf<Article?>(null) }
    val isAnimate by remember { mutableStateOf(false) }
    val transition = rememberInfiniteTransition()
    val rotate by transition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing)
        )
    )
    LaunchedEffect(Unit) {
        viewModel.getArticle(index = dataId)
    }
    val isLoading = remember { mutableStateOf(true) }
    val state by viewModel.article.collectAsState()

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
            article = response
        }
    }

    Scaffold(
        topBar = {
            Surface(
                shadowElevation = 9.dp, // play with the elevation values
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().height(58.dp)
                        .background(MaterialTheme.colorScheme.surfaceContainerLowest),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Spacer(modifier = Modifier.width(16.dp))
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Column(
                        modifier = Modifier.padding(start = 4.dp),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "${article?.source?.name}".toCapitalize(),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))

                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        },
        containerColor = MaterialTheme.colorScheme.surfaceContainer
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(scrollState)
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 16.dp,
                    bottom = 58.dp
                )
        ) {
            AsyncImage(
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .run { if (isAnimate) rotate(rotate) else this },
                model = article?.urlToImage,
                contentDescription = article?.description,
                error = painterResource(Res.drawable.error_404),
            )
            Spacer(modifier = Modifier.height(8.dp))


            Text(
                text = "${article?.title}",
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Published: ${
                    formatDateString(
                        article?.publishedAt
                    )
                }",
                style = MaterialTheme.typography.bodySmall,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "By: ${article?.author}",
                style = MaterialTheme.typography.bodySmall,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "copyright: ${article?.source?.name}",
                style = MaterialTheme.typography.bodySmall,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Divider(startIndent = 0.dp, thickness = 1.dp, color = Color.Gray.copy(alpha = 0.5f))
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                    text = "${article?.description}",
                    style = MaterialTheme.typography.bodyMedium,
                )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "${article?.content}",
                style = MaterialTheme.typography.bodyMedium,
            )

        }
    }


}