package com.codecrafterpro.base_project.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codecrafterpro.base_project.core.domain.usecase.GetEpisodesUseCase
import com.codecrafterpro.base_project.core.model.Resource
import com.codecrafterpro.base_project.core.model.episode.Episodes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(val getEpisodesUseCase: GetEpisodesUseCase): ViewModel() {

    private val _homeState = MutableStateFlow(HomeState())
    val homeState: StateFlow<HomeState> = _homeState.asStateFlow()

    init {
        getEpisodes()
    }
    private fun getEpisodes(){
        getEpisodesUseCase().onEach {
            when (it) {
                is Resource.Loading -> {
                    _homeState.value = HomeState(isLoading = true)
                }
                is Resource.Error -> {
                    _homeState.value = HomeState(error = "Invalid credentials")
                }
                is Resource.Success -> {
                    _homeState.value = HomeState(data = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}

data class HomeState(
    val isLoading: Boolean = false,
    val error: String = "",
    val data: Episodes? = null
)