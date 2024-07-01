package com.codecrafterpro.base_project.features.articles

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codecrafterpro.base_project.core.domain.usecase.GetCharactersUseCase
import com.codecrafterpro.base_project.core.model.Resource
import com.codecrafterpro.base_project.core.model.character.Characters
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ArticlesScreenViewModel @Inject constructor(
    val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {

    private val _articlesState = MutableStateFlow(ArticlesState())
    val articlesState: StateFlow<ArticlesState> = _articlesState.asStateFlow()

    init {
        getCharacters()
    }

    private fun getCharacters() {
        getCharactersUseCase().onEach {
            when (it) {
                is Resource.Loading -> {
                    _articlesState.value = ArticlesState(isLoading = true)
                }

                is Resource.Error -> {
                    _articlesState.value = ArticlesState(error = "Invalid credentials")
                }

                is Resource.Success -> {
                    _articlesState.value = ArticlesState(data = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}

data class ArticlesState(
    val isLoading: Boolean = false,
    val error: String = "",
    val data: Characters? = null
)