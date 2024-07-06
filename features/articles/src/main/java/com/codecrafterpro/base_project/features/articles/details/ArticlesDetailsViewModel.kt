package com.codecrafterpro.base_project.features.articles.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codecrafterpro.base_project.core.domain.usecase.GetCharacterDetailsUseCase
import com.codecrafterpro.base_project.core.model.Resource
import com.codecrafterpro.base_project.core.model.character.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ArticlesDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    val getCharacterDetailsUseCase: GetCharacterDetailsUseCase
): ViewModel() {

    private val _articlesDetailsState = MutableStateFlow(ArticlesDetailsState())
    val articlesDetailsState: StateFlow<ArticlesDetailsState> = _articlesDetailsState.asStateFlow()
    init {
        val articleId: Int? = savedStateHandle["articleId"]
        articleId?.let {
            getArticleDetailsInfo(articleId)
        }
    }

    private fun getArticleDetailsInfo(articleId: Int){
        getCharacterDetailsUseCase(articleId.toString()).onEach {
            when (it) {
                is Resource.Loading -> {
                    _articlesDetailsState.value = ArticlesDetailsState(isLoading = true)
                }

                is Resource.Error -> {
                    _articlesDetailsState.value = ArticlesDetailsState(error = "Invalid credentials")
                }

                is Resource.Success -> {
                    _articlesDetailsState.value = ArticlesDetailsState(data = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}

data class ArticlesDetailsState(
    val isLoading: Boolean = false,
    val error: String = "",
    val data: Character? = null
)