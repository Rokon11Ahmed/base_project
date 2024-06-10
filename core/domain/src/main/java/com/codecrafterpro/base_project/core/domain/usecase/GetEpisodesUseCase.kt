package com.codecrafterpro.base_project.core.domain.usecase

import com.codecrafterpro.base_project.core.data.repository.EpisodesRepository
import com.codecrafterpro.base_project.core.model.Resource
import com.codecrafterpro.base_project.core.model.episode.Episodes
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetEpisodesUseCase @Inject constructor(private val repository: EpisodesRepository) {
    operator fun invoke(): Flow<Resource<Episodes>> = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(repository.getEpisodes()))
        }catch (e: Exception){
            emit(Resource.Error(e.localizedMessage))
        }
    }
}