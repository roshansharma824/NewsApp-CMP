package com.exmaple.newsapp.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import news_app.composeapp.generated.resources.Res
import news_app.composeapp.generated.resources.avatar
import org.jetbrains.compose.resources.painterResource

@Composable
fun LocalAvatar(onProfileClick: ()-> Unit) {
    Image(
        painter = painterResource(Res.drawable.avatar),
        contentDescription = null,
        modifier = Modifier.size(40.dp)
            .clickable { onProfileClick() }
    )
}