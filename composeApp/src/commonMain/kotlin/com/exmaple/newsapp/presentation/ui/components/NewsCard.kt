package com.exmaple.newsapp.presentation.ui.components

import androidx.compose.animation.core.LinearEasing
import com.exmaple.newsapp.utils.formatDateString
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.exmaple.newsapp.domain.model.Result
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

@Composable
fun NewsCard(item: Result, onItemClick :() -> Unit) {
    val imageUrl = item.multimedia?.getOrNull(0)?.url?.let { asyncPainterResource(it) }
//    val navigator = LocalNavigator.currentOrThrow
    val isAnimate by remember { mutableStateOf(false) }
    val transition = rememberInfiniteTransition()
    val rotate by transition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing)
        )
    )

    imageUrl?.let {
        Card(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceContainer
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            ),
            shape = RoundedCornerShape(12.dp),
            onClick = {
                onItemClick.invoke()
//                navigator.push(DetailScreen(item))
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                AsyncImage(
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .run { if (isAnimate) rotate(rotate) else this },
                    model = item.multimedia.getOrNull(0)?.url,
                    contentDescription = null
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "${item.title}",
                        style = MaterialTheme.typography.headlineSmall.copy(
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "${item.abstract}",
                        style = MaterialTheme.typography.bodySmall,
                        maxLines = 2
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "${item.byline}",
                        style = MaterialTheme.typography.bodySmall.copy(color = Color.Gray),
                        fontSize = 12.sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Published ${
                            item.published_date?.let {
                                formatDateString(
                                    it
                                )
                            }
                        }",
                        style = MaterialTheme.typography.bodySmall.copy(color = Color.Gray),
                        fontSize = 12.sp
                    )
                }
            }
        }
    }

}


//@Preview()
//@Composable
//fun NewsCardPreview() {
//    NewsCard()
//}