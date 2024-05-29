package data.repository

import domain.model.NewsData
import org.koin.core.annotation.Single

@Single
interface NewsApi {

    suspend fun getTopStories(): NewsData
}