package com.sibtain.newsapp.domain.usecase

import com.sibtain.newsapp.domain.model.NewsArticle
import com.sibtain.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchNewsUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    suspend operator fun invoke(query: String, apiKey: String): Flow<List<NewsArticle>> {
        return repository.searchNews(query, apiKey)
    }
}
