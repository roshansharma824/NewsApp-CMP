package com.exmaple.newsapp.presentation.viewmodels


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exmaple.newsapp.domain.repository.Repository
import org.koin.android.annotation.KoinViewModel
import com.exmaple.newsapp.domain.model.NewsData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import com.exmaple.newsapp.domain.usecase.ResultState


@KoinViewModel
class MainViewModel(
    private val repository: Repository,
) : ViewModel() {

    private val _newsData = MutableStateFlow<ResultState<NewsData>>(ResultState.Loading)
    val newsData: StateFlow<ResultState<NewsData>> = _newsData.asStateFlow()

    fun getNewsData() {
        viewModelScope.launch {
            _newsData.value = ResultState.Loading
            try {
                val response = repository.getTopStories()
                _newsData.value = ResultState.Success(response)
            } catch (e: Exception) {
                _newsData.value = ResultState.Error(e)
            }
        }
    }

}