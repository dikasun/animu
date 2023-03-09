package com.andikas.animu.core.domain.usecase

import com.andikas.animu.core.domain.model.Anime
import com.andikas.animu.core.data.Resource
import kotlinx.coroutines.flow.Flow

interface AnimeUseCase {

    fun getRecentReleaseAnime(): Flow<Resource<List<Anime>>>

    fun getPopularAnime(): Flow<Resource<List<Anime>>>

    fun getTopAiringAnime(): Flow<Resource<List<Anime>>>

    fun getDetailRecentReleaseAnime(id: Long, anime: String): Flow<Resource<Anime>>

    fun getDetailPopularAnime(id: Long, anime: String): Flow<Resource<Anime>>

    fun getDetailTopAiringAnime(id: Long, anime: String): Flow<Resource<Anime>>

}