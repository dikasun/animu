package com.andikas.animu.core.domain.usecase

import com.andikas.animu.core.data.Resource
import com.andikas.animu.core.domain.model.Anime
import kotlinx.coroutines.flow.Flow

interface AnimeUseCase {

    fun getRecentReleaseAnime(): Flow<Resource<List<Anime>>>

    fun getPopularAnime(): Flow<Resource<List<Anime>>>

    fun getTopAiringAnime(): Flow<Resource<List<Anime>>>

    fun getFavoriteRecentReleaseAnime(): Flow<List<Anime>>
    suspend fun setFavoriteRecentReleaseAnime(anime: Anime, state: Boolean)

    fun getFavoritePopularAnime(): Flow<List<Anime>>
    suspend fun setFavoritePopularAnime(anime: Anime, state: Boolean)

    fun getFavoriteTopAiringAnime(): Flow<List<Anime>>
    suspend fun setFavoriteTopAiringAnime(anime: Anime, state: Boolean)

    fun getDetailRecentReleaseAnime(
        id: Long,
        anime: String,
        isFavorite: Boolean,
    ): Flow<Resource<Anime>>

    fun getDetailPopularAnime(
        id: Long,
        anime: String,
        isFavorite: Boolean,
    ): Flow<Resource<Anime>>

    fun getDetailTopAiringAnime(
        id: Long,
        anime: String,
        isFavorite: Boolean,
    ): Flow<Resource<Anime>>

}