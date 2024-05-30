package presentation.ui.components

import Utils.calculateTimeDifferenceInHoursAndMinutes
import Utils.formatDateString
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import domain.model.Result
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import presentation.ui.screens.detail.DetailScreen

@Composable
fun NewsCard(item: Result) {
    val imageUrl = item.multimedia?.getOrNull(0)?.url?.let { asyncPainterResource(it) }
    val navigator = LocalNavigator.currentOrThrow

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
                navigator.push(DetailScreen(item))
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                KamelImage(
                    resource = imageUrl,
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Crop,
                    animationSpec = tween(
                        durationMillis = 200,
                        delayMillis = 100,
                        easing = LinearOutSlowInEasing
                    ),
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