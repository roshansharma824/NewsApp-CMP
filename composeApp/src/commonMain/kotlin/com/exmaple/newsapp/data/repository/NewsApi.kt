package com.exmaple.newsapp.data.repository

import com.exmaple.newsapp.domain.model.NewsData
import org.koin.core.annotation.Single

@Single
interface NewsApi {

    suspend fun getTopStories(): NewsData
}