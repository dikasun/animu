package com.andikas.animu.core.domain.model

data class Anime(
    var id: Long,
    var animeId: String,
    var animeImg: String,
    var animeTitle: String,
    var otherNames: String,
    var totalEpisodes: String,
    var genres: List<String>,
    var status: String,
    var synopsis: String,
    var releasedDate: String,
    var type: String,
)
