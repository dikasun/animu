package com.andikas.animu.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class AnimeDetailResponse(
    @SerializedName("animeImg")
    var animeImg: String = "",

    @SerializedName("animeTitle")
    var animeTitle: String = "",

    @SerializedName("episodesList")
    var episodesList: List<Episodes> = listOf(),

    @SerializedName("genres")
    var genres: List<String> = listOf(),

    @SerializedName("otherNames")
    var otherNames: String = "",

    @SerializedName("releasedDate")
    var releasedDate: String = "",

    @SerializedName("status")
    var status: String = "",

    @SerializedName("synopsis")
    var synopsis: String = "",

    @SerializedName("totalEpisodes")
    var totalEpisodes: String = "",

    @SerializedName("type")
    var type: String = ""
)

data class Episodes(
    @SerializedName("episodeId")
    var episodeId: String = "",

    @SerializedName("episodeNum")
    var episodeNum: String = "",

    @SerializedName("episodeUrl")
    var episodeUrl: String = ""
)