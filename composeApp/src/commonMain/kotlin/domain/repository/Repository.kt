package domain.repository

import data.remote.NewsApiClient
import data.repository.NewsApi
import domain.model.NewsData

class Repository : NewsApi {
    override suspend fun getTopStories(): NewsData {
        return NewsApiClient.getTopStories()
    }
}