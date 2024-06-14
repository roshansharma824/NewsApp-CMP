import androidx.compose.ui.window.ComposeUIViewController
import com.exmaple.newsapp.App
import com.exmaple.newsapp.di.appModule
import platform.UIKit.UIViewController
import org.koin.core.context.startKoin

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
fun initKoin(){
    startKoin {
        modules(appModule)
    }
}