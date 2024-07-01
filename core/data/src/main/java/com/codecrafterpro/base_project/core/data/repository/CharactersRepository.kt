package com.codecrafterpro.base_project.core.data.repository

import com.codecrafterpro.base_project.core.model.character.Characters
import com.codecrafterpro.base_project.core.model.character.toDomainCharacters
import com.codecrafterpro.base_project.core.model.episode.Episodes
import com.codecrafterpro.base_project.core.model.episode.toDomainEpisode
import com.codecrafterpro.base_project.core.network.ktor.ApiService
import javax.inject.Inject

class CharactersRepository @Inject constructor(private val apiService: ApiService){

    suspend fun getCharacters(): Characters {
        return apiService.getCharacters().toDomainCharacters()
    }
}