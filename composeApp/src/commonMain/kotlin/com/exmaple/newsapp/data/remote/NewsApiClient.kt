package com.exmaple.newsapp.data.remote

import com.exmaple.newsapp.domain.model.NewsData
import com.exmaple.newsapp.utils.Constant.API_SECRET
import com.exmaple.newsapp.utils.Constant.BASE_URL
import com.exmaple.newsapp.utils.Constant.TIME_OUT
import com.exmaple.newsapp.utils.Constant.newsData
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.delay
import kotlinx.serialization.json.Json

object NewsApiClient {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(contentType = ContentType.Application.Json,
                json = Json {
                    isLenient = true
                    ignoreUnknownKeys = true
                }
            )
        }
        install(Logging) {
            level = LogLevel.ALL
            logger = object : Logger {
                override fun log(message: String) {
                    println(message)
                }
            }
        }
        install(HttpTimeout) {
            socketTimeoutMillis = TIME_OUT
            connectTimeoutMillis = TIME_OUT
            requestTimeoutMillis = TIME_OUT
        }
    }

    suspend fun getTopStories(category: String): NewsData {
        val url = "$BASE_URL/top-headlines?country=in&category=${category}&apiKey=$API_SECRET"
        return client.get(url).body()
//        delay(2000)
//        return newsData
    }
}