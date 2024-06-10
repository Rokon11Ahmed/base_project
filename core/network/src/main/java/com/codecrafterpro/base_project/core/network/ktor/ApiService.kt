package com.codecrafterpro.base_project.core.network.ktor

import com.codecrafterpro.base_project.core.model.episode.EpisodesRemoteResponse

interface ApiService {
    suspend fun getEpisodes():EpisodesRemoteResponse
}