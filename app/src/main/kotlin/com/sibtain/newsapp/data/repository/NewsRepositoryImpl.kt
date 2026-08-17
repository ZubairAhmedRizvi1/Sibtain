package com.sibtain.newsapp.data.repository

import com.sibtain.newsapp.data.api.NewsApiService
import com.sibtain.newsapp.domain.model.NewsArticle
import com.sibtain.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val apiService: NewsApiService
) : NewsRepository {
    
    override suspend fun getTopHeadlines(apiKey: String): Flow<List<NewsArticle>> = flow {
        try {
            val response = apiService.getTopHeadlines(apiKey = apiKey)
            emit(response.articles.map { it.toArticle() })
        } catch (e: Exception) {
            emit(emptyList())
        }
    }

    override suspend fun searchNews(query: String, apiKey: String): Flow<List<NewsArticle>> = flow {
        try {
            val response = apiService.searchNews(query = query, apiKey = apiKey)
            emit(response.articles.map { it.toArticle() })
        } catch (e: Exception) {
            emit(emptyList())
        }
    }
}
