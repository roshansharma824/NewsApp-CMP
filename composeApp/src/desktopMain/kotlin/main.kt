import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import di.appModule
import org.koin.core.context.startKoin
import java.awt.Dimension

fun main() = application {

    startKoin {
        modules(appModule)
    }
    Window(
        title = "News App",
        state = rememberWindowState(width = 420.dp, height = 1080.dp),
        onCloseRequest = ::exitApplication,
    ) {
        window.minimumSize = Dimension(420, 600)
        App()
    }
}