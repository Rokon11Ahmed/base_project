package com.codecrafterpro.base_project.core.domain.usecase

import com.codecrafterpro.base_project.core.data.repository.CharactersRepository
import com.codecrafterpro.base_project.core.model.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.codecrafterpro.base_project.core.model.character.Character
import javax.inject.Inject

class GetCharacterDetailsUseCase @Inject constructor(private val repository: CharactersRepository) {
    operator fun invoke(id: String): Flow<Resource<Character>> = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(repository.getCharacterDetails(id)))
        }catch (e: Exception){
            emit(Resource.Error(e.localizedMessage))
        }
    }
}