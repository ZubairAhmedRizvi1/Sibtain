package com.sibtain.newsapp.domain.repository

import com.sibtain.newsapp.domain.model.NewsArticle
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    suspend fun getTopHeadlines(apiKey: String): Flow<List<NewsArticle>>
    suspend fun searchNews(query: String, apiKey: String): Flow<List<NewsArticle>>
}
