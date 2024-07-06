package com.codecrafterpro.base_project.core.domain.usecase

import android.util.Log
import com.codecrafterpro.base_project.core.data.repository.CharactersRepository
import com.codecrafterpro.base_project.core.data.repository.EpisodesRepository
import com.codecrafterpro.base_project.core.model.Resource
import com.codecrafterpro.base_project.core.model.character.Characters
import com.codecrafterpro.base_project.core.model.episode.Episodes
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(private val repository: CharactersRepository) {
    operator fun invoke(): Flow<Resource<Characters>> = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(repository.getCharacters()))
        }catch (e: Exception){
            emit(Resource.Error(e.localizedMessage))
        }
    }
}