package com.andikas.animu.core.domain.usecase

import com.andikas.animu.core.domain.model.Anime
import com.andikas.animu.core.domain.repository.IAnimeRepository
import com.andikas.animu.core.data.Resource
import kotlinx.coroutines.flow.Flow

class AnimeInteractor(private val animeRepository: IAnimeRepository) : AnimeUseCase {

    override fun getRecentReleaseAnime(): Flow<Resource<List<Anime>>> =
        animeRepository.getRecentReleaseAnime()

    override fun getPopularAnime(): Flow<Resource<List<Anime>>> =
        animeRepository.getPopularAnime()

    override fun getTopAiringAnime(): Flow<Resource<List<Anime>>> =
        animeRepository.getTopAiringAnime()

    override fun getDetailRecentReleaseAnime(id: Long, anime: String): Flow<Resource<Anime>> =
        animeRepository.getDetailRecentReleaseAnime(id, anime)

    override fun getDetailPopularAnime(id: Long, anime: String): Flow<Resource<Anime>> =
        animeRepository.getDetailPopularAnime(id, anime)

    override fun getDetailTopAiringAnime(id: Long, anime: String): Flow<Resource<Anime>> =
        animeRepository.getDetailTopAiringAnime(id, anime)
}