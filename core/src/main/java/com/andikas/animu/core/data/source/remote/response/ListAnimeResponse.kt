package com.andikas.animu.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

class ListAnimeResponse : ArrayList<AnimeResponse>()

data class AnimeResponse(
    @SerializedName("animeId")
    var animeId: String = "",

    @SerializedName("animeImg")
    var animeImg: String = "",

    @SerializedName("animeTitle")
    var animeTitle: String = "",

    @SerializedName("episodeId")
    var episodeId: String = "",

    @SerializedName("episodeNum")
    var episodeNum: String = "",

    @SerializedName("episodeUrl")
    var episodeUrl: String = "",

    @SerializedName("subOrDub")
    var subOrDub: String = ""
)