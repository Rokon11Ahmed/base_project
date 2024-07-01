package com.codecrafterpro.base_project.core.model.character

import kotlinx.serialization.Serializable

@Serializable
data class RemoteCharacter(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

@Serializable
data class Location(
    val name: String,
    val url: String
)

@Serializable
data class Origin(
    val name: String,
    val url: String
)

fun RemoteCharacter.toDomainCharacter(): Character{
    return Character(
        id = id,
        name = name,
        image = image,
        status = status,
        location = location.name
    )
}