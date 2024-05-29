package com.example.newsapp

import App
import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AndroidApp : Application() {
    companion object {
        lateinit var INSTANCE: AndroidApp
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        startKoin {
            androidContext(this@AndroidApp)
            androidLogger()
            modules(appModule)
        }
    }
}

class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { App() }
    }
}

//internal actual fun openUrl(url: String?) {
//    val uri = url?.let { Uri.parse(it) } ?: return
//    val intent = Intent().apply {
//        action = Intent.ACTION_VIEW
//        data = uri
//        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//    }
//    AndroidApp.INSTANCE.startActivity(intent)
//}

//actual fun getPlatform(): Platform {
//    return Platform.Android
//}

//actual class DriverFactory actual constructor() {
//    private var context: Context = AndroidApp.INSTANCE.applicationContext
//    actual fun createDriver(): SqlDriver {
//        return AndroidSqliteDriver(MyDatabase.Schema,context,"MyDatabase.db")
//    }
//}