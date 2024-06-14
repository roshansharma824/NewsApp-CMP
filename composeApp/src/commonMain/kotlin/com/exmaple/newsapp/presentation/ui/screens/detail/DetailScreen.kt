package com.exmaple.newsapp.presentation.ui.screens.detail

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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.exmaple.newsapp.utils.toCapitalize

@Composable
fun DetailScreen(modifier: Modifier = Modifier, navController: NavHostController, dataId: String) {

//    val navigator: Navigator = LocalNavigator.currentOrThrow
    val scrollState = rememberScrollState()


//    val imageUrl = result.multimedia?.getOrNull(0)?.url?.let { asyncPainterResource(it) }!!

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
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Column(
                        modifier = Modifier.padding(start = 4.dp),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "ijh".toCapitalize(),
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
//            KamelImage(
//                resource = imageUrl,
//                contentDescription = null,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(200.dp)
//                    .clip(shape = RoundedCornerShape(12.dp)),
//                contentScale = ContentScale.Crop,
//                animationSpec = tween(
//                    durationMillis = 200,
//                    delayMillis = 100,
//                    easing = LinearOutSlowInEasing
//                ),
//            )
            Spacer(modifier = Modifier.height(8.dp))


            Text(
                text = "lkjhg",
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Published: kjh}",
                style = MaterialTheme.typography.bodySmall,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "By: kjhg",
                style = MaterialTheme.typography.bodySmall,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "copyright: lkjh",
                style = MaterialTheme.typography.bodySmall,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Divider(startIndent = 0.dp, thickness = 1.dp, color = Color.Gray.copy(alpha = 0.5f))
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "mnb",
                style = MaterialTheme.typography.bodyMedium,
            )
//            for (media in result.multimedia) {
//                Spacer(modifier = Modifier.height(8.dp))
//                Text(
//                    text = "${media.caption}",
//                    style = MaterialTheme.typography.bodyMedium,
//                )
//            }
            Spacer(modifier = Modifier.height(16.dp))

        }
    }


}