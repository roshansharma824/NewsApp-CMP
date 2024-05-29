package Utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform


@Composable
expect fun PlatformColors(statusBarColor: Color, navBarColor: Color)