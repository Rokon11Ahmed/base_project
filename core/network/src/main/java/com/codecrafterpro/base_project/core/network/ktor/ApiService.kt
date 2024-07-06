package com.codecrafterpro.base_project.core.network.ktor

import com.codecrafterpro.base_project.core.model.character.CharactersRemoteResponse
import com.codecrafterpro.base_project.core.model.character.RemoteCharacter
import com.codecrafterpro.base_project.core.model.episode.EpisodesRemoteResponse

interface ApiService {
    suspend fun getEpisodes(): EpisodesRemoteResponse
    suspend fun getCharacters(): CharactersRemoteResponse
    suspend fun getCharacterDetails(id: String): RemoteCharacter
}