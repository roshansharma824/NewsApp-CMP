package com.exmaple.newsapp.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.exmaple.newsapp.theme.LocalThemeIsDark
import io.kamel.core.Resource
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

@Composable
fun TopAppBarWithProfile(
    name: String,
    itemCount: Int,
    onCartClicked: () -> Unit,
    onProfileClick: () -> Unit,
    profileImageUrl: String? = null,
) {
    val isDark by LocalThemeIsDark.current
    Surface(
        shadowElevation = 9.dp, // play with the elevation values
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().height(58.dp).background(MaterialTheme.colorScheme.surfaceContainerLowest),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Spacer(modifier = Modifier.width(16.dp))
            if (profileImageUrl?.isNotEmpty() == true) {
                var profile by remember { mutableStateOf("") }
                profileImageUrl.let {
                    profile = it
                }
                val image: Resource<Painter> = asyncPainterResource(data = profile)
                KamelImage(
                    resource = image,
                    contentDescription = "Profile",
                    modifier = Modifier.size(55.dp)
                        .clip(CircleShape)
                        .clickable {
                            onProfileClick()
                        }
                )
            } else {
                LocalAvatar { onProfileClick() }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier.padding(start = 4.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Hi, $name",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = MaterialTheme.typography.titleSmall.fontSize,
                    color =if (isDark)Color.White else Color.Black,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "Read top stories",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.LightGray,
                    fontSize = MaterialTheme.typography.bodySmall.fontSize
                )
            }
            Spacer(modifier = Modifier.weight(1f))

            Spacer(modifier = Modifier.width(8.dp))
        }
    }

}