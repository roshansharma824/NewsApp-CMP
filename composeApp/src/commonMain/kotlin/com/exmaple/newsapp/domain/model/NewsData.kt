package com.exmaple.newsapp.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class NewsData(

    @SerialName("articles")
    val articles: List<Article>,

    @SerialName("status")
    val status: String,

    @SerialName("totalResults")
    val totalResults: Int
)