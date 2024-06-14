import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import com.exmaple.newsapp.App
import com.exmaple.newsapp.di.appModule
import org.jetbrains.skiko.wasm.onWasmReady
import org.koin.core.context.startKoin


@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    startKoin {
        modules(appModule)
    }
    onWasmReady {
        CanvasBasedWindow("News App") {
            App()
        }
    }
}
