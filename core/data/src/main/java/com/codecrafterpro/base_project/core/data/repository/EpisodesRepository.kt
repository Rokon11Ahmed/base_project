package com.codecrafterpro.base_project.core.data.repository

import android.util.Log
import com.codecrafterpro.base_project.core.model.episode.Episodes
import com.codecrafterpro.base_project.core.model.episode.toDomainEpisode
import com.codecrafterpro.base_project.core.network.ktor.ApiService
import javax.inject.Inject

class EpisodesRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getEpisodes(): Episodes {
        return apiService.getEpisodes().toDomainEpisode()
    }
}