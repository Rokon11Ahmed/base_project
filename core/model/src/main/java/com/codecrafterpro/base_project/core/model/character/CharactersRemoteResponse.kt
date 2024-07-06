package com.codecrafterpro.base_project.core.model.character

import kotlinx.serialization.Serializable

@Serializable
data class CharactersRemoteResponse(
    val info: Info,
    val results: List<RemoteCharacter>
)

@Serializable
data class Info(
    val count: Int,
    val next: String?,
    val pages: Int,
    val prev: String?
)

fun CharactersRemoteResponse.toDomainCharacters(): Characters{
    return Characters(
        info = this.info,
        results = results.map { it.toDomainCharacter() }
    )
}
