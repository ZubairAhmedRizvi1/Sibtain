package com.sibtain.newsapp.domain.model

data class NewsArticle(
    val id: Long,
    val source: String,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val imageUrl: String?,
    val publishedAt: String,
    val content: String
)
