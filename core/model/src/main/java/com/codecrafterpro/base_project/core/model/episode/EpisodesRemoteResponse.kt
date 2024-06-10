package com.codecrafterpro.base_project.core.model.episode

import kotlinx.serialization.Serializable

@Serializable
data class EpisodesRemoteResponse(
    var info: Info,
    var results: ArrayList<RemoteEpisode>
)

@Serializable
data class Info (
    var count: Int,
    var pages: Int,
    var next: String?,
    var prev: String?,
)

fun EpisodesRemoteResponse.toDomainEpisode(): Episodes {
    return Episodes(
        info = this.info,
        results = results.map {it.toDomainEpisode()}
    )
}