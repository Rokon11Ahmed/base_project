package com.codecrafterpro.base_project.core.model.episode

data class Episodes(
    var info: Info,
    var results: List<Episode>
){
    data class Episode(
        var id: Int,
        var name: String,
        var publishDate: String,
        var episodeCode: String,
        var characters: ArrayList<String>,
        var episodeUrl: String,
        var created: String
    )
}
