package di

import domain.repository.Repository
import org.koin.dsl.module
import presentation.viewmodels.MainViewModel

val appModule = module {
    single { Repository() }
    single {
        MainViewModel(get())
    }
}