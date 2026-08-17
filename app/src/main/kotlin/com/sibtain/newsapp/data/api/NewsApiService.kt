package com.sibtain.newsapp.data.api

import com.sibtain.newsapp.domain.model.NewsArticle
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String = "us",
        @Query("apiKey") apiKey: String
    ): NewsResponse

    @GET("everything")
    suspend fun searchNews(
        @Query("q") query: String,
        @Query("sortBy") sortBy: String = "publishedAt",
        @Query("apiKey") apiKey: String
    ): NewsResponse
}

data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<ArticleDto>
)

data class ArticleDto(
    val source: SourceDto,
    val author: String?,
    val title: String,
    val description: String?,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String,
    val content: String?
) {
    fun toArticle() = NewsArticle(
        id = url.hashCode().toLong(),
        source = source.name,
        author = author ?: "Unknown",
        title = title,
        description = description ?: "",
        url = url,
        imageUrl = urlToImage,
        publishedAt = publishedAt,
        content = content ?: ""
    )
}

data class SourceDto(
    val id: String?,
    val name: String
)
