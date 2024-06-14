package com.exmaple.newsapp.domain.repository

import com.exmaple.newsapp.data.remote.NewsApiClient
import com.exmaple.newsapp.data.repository.NewsApi
import com.exmaple.newsapp.domain.model.NewsData

class Repository : NewsApi {
    override suspend fun getTopStories(): NewsData {
        return NewsApiClient.getTopStories()
    }
}