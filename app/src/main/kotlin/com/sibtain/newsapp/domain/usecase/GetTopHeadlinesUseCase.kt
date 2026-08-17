package com.sibtain.newsapp.domain.usecase

import com.sibtain.newsapp.domain.model.NewsArticle
import com.sibtain.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTopHeadlinesUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    suspend operator fun invoke(apiKey: String): Flow<List<NewsArticle>> {
        return repository.getTopHeadlines(apiKey)
    }
}
