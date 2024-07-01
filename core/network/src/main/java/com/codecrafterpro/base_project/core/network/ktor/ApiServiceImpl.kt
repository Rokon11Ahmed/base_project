package com.codecrafterpro.base_project.core.network.ktor

import com.codecrafterpro.base_project.core.model.character.CharactersRemoteResponse
import com.codecrafterpro.base_project.core.model.episode.EpisodesRemoteResponse
import com.codecrafterpro.base_project.core.network.utils.Constant.CHARACTERS
import com.codecrafterpro.base_project.core.network.utils.Constant.EPISODES
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import javax.inject.Inject

class ApiServiceImpl @Inject constructor(private val httpClient: HttpClient): ApiService {
    override suspend fun getEpisodes(): EpisodesRemoteResponse {
        return httpClient.get(EPISODES).body<EpisodesRemoteResponse>()
    }

    override suspend fun getCharacters(): CharactersRemoteResponse {
        return httpClient.get(CHARACTERS).body<CharactersRemoteResponse>()
    }
}