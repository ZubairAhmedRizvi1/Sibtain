package com.sibtain.newsapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sibtain.newsapp.domain.model.NewsArticle
import com.sibtain.newsapp.domain.usecase.GetTopHeadlinesUseCase
import com.sibtain.newsapp.domain.usecase.SearchNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class NewsUiState(
    val articles: List<NewsArticle> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val searchQuery: String = ""
)

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getTopHeadlinesUseCase: GetTopHeadlinesUseCase,
    private val searchNewsUseCase: SearchNewsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(NewsUiState())
    val uiState: StateFlow<NewsUiState> = _uiState.asStateFlow()

    private val apiKey = "YOUR_API_KEY_HERE" // Replace with actual API key

    init {
        loadTopHeadlines()
    }

    fun loadTopHeadlines() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)
            try {
                getTopHeadlinesUseCase(apiKey).collect { articles ->
                    _uiState.value = _uiState.value.copy(
                        articles = articles,
                        isLoading = false
                    )
                }
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = e.message ?: "Unknown error occurred"
                )
            }
        }
    }

    fun searchNews(query: String) {
        if (query.isBlank()) {
            loadTopHeadlines()
            return
        }
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null, searchQuery = query)
            try {
                searchNewsUseCase(query, apiKey).collect { articles ->
                    _uiState.value = _uiState.value.copy(
                        articles = articles,
                        isLoading = false
                    )
                }
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = e.message ?: "Unknown error occurred"
                )
            }
        }
    }
}
