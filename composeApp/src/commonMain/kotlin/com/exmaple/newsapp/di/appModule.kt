package com.exmaple.newsapp.di

import com.exmaple.newsapp.domain.repository.Repository
import org.koin.dsl.module
import com.exmaple.newsapp.presentation.viewmodels.MainViewModel

val appModule = module {
    single { Repository() }
    single {
        MainViewModel(get())
    }
}