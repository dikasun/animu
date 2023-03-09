package com.andikas.animu.core.data.source.remote.network

import com.andikas.animu.core.data.source.remote.response.AnimeDetailResponse
import com.andikas.animu.core.data.source.remote.response.ListAnimeResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("recent-release")
    suspend fun getRecentReleaseAnime(): ListAnimeResponse

    @GET("popular")
    suspend fun getPopularAnime(): ListAnimeResponse

    @GET("top-airing")
    suspend fun getTopAiringAnime(): ListAnimeResponse

    @GET("anime-details/{anime}")
    suspend fun getDetailAnime(@Path("anime") anime: String): AnimeDetailResponse
}