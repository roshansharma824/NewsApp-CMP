package com.exmaple.newsapp.presentation.viewmodels


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exmaple.newsapp.domain.model.Article
import com.exmaple.newsapp.domain.model.NewsData
import com.exmaple.newsapp.domain.repository.Repository
import org.koin.android.annotation.KoinViewModel
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

    private val _article= MutableStateFlow<ResultState<Article>>(ResultState.Loading)
    val article: StateFlow<ResultState<Article>> = _article.asStateFlow()

    fun getNewsData(category: String = "") {
        viewModelScope.launch {
            _newsData.value = ResultState.Loading
            try {
                val response = repository.getTopStories(category)
                _newsData.value = ResultState.Success(response)
            } catch (e: Exception) {
                _newsData.value = ResultState.Error(e)
            }
        }
    }

    fun getArticle(index: Int) {
        viewModelScope.launch {
            _newsData.value.let {
                if (it is ResultState.Success) {
                    val article = it.response.articles[index]
                    _article.value = ResultState.Success(article)
                }
            }
        }
    }

}