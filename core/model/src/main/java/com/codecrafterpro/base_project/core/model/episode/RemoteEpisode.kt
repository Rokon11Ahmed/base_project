package com.codecrafterpro.base_project.core.model.episode

import kotlinx.serialization.Serializable

@Serializable
data class RemoteEpisode(
    var id: Int,
    var name: String,
    var air_date: String,
    var episode: String,
    var characters: ArrayList<String>,
    var url: String,
    var created: String
)

fun RemoteEpisode.toDomainEpisode(): Episodes.Episode {
    return Episodes.Episode(
        id = id,
        name = name,
        publishDate = air_date,
        episodeCode = episode,
        characters = characters,
        episodeUrl = url,
        created = created
    )
}