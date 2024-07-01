package com.codecrafterpro.base_project.core.model.character

data class Characters (
    val info: Info,
    val results: List<Character>
)

data class Character (
    val id: Int,
    val name: String,
    val image: String,
    val status: String,
    val location: String
)