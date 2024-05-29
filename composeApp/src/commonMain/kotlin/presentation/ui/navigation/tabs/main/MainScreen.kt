package presentation.ui.navigation.tabs.main

import AppContent
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

class MainScreen(val userEmail: String?) : Screen {
    @Composable
    override fun Content() {
        AppContent()
        println("User Email: $userEmail")
    }
}