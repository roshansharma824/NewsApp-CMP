import androidx.compose.ui.window.ComposeUIViewController
import di.appModule
import org.koin.core.context.startKoin
import platform.UIKit.UIViewController
import kotlin.native.concurrent.ThreadLocal

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
fun initKoin() {
    startKoin {
        modules(appModule)
    }
}

// iOSMain
//@Suppress("unused")
//@ThreadLocal
//object Main_iosKt {
//    fun doInitKoin() {
//        initKoin()
//    }
//}