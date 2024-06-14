package com.exmaple.newsapp

import androidx.compose.runtime.*
import com.exmaple.newsapp.theme.AppTheme
import com.exmaple.newsapp.presentation.ui.screens.MainScreen

@Composable
internal fun App() = AppTheme {
    MainScreen()
}

internal expect fun openUrl(url: String?)