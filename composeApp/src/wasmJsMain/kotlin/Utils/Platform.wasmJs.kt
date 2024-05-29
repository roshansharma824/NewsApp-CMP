package Utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

class WasmPlatform: Platform {
    override val name: String = "Web with Kotlin/Wasm"
}

actual fun getPlatform(): Platform = WasmPlatform()

@Composable
actual fun PlatformColors(
    statusBarColor: Color,
    navBarColor: Color
) {
}