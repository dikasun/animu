package com.andikas.animu.core.domain.usecase

import com.andikas.animu.core.data.Resource
import com.andikas.animu.core.domain.model.Anime
import com.andikas.animu.core.domain.repository.IAnimeRepository
import kotlinx.coroutines.flow.Flow

class AnimeInteractor(private val animeRepository: IAnimeRepository) : AnimeUseCase {

    override fun getRecentReleaseAnime(): Flow<Resource<List<Anime>>> =
        animeRepository.getRecentReleaseAnime()

    override fun getPopularAnime(): Flow<Resource<List<Anime>>> =
        animeRepository.getPopularAnime()

    override fun getTopAiringAnime(): Flow<Resource<List<Anime>>> =
        animeRepository.getTopAiringAnime()

    override fun getFavoriteRecentReleaseAnime(): Flow<List<Anime>> =
        animeRepository.getFavoriteRecentReleaseAnime()

    override suspend fun setFavoriteRecentReleaseAnime(
        anime: Anime,
        state: Boolean
    ) = animeRepository.setFavoriteRecentReleaseAnime(anime, state)

    override fun getFavoritePopularAnime(): Flow<List<Anime>> =
        animeRepository.getFavoritePopularAnime()

    override suspend fun setFavoritePopularAnime(
        anime: Anime,
        state: Boolean
    ) = animeRepository.setFavoritePopularAnime(anime, state)

    override fun getFavoriteTopAiringAnime(): Flow<List<Anime>> =
        animeRepository.getFavoriteTopAiringAnime()

    override suspend fun setFavoriteTopAiringAnime(
        anime: Anime,
        state: Boolean
    ) = animeRepository.setFavoriteTopAiringAnime(anime, state)

    override fun getDetailRecentReleaseAnime(
        id: Long,
        anime: String,
        isFavorite: Boolean,
    ): Flow<Resource<Anime>> =
        animeRepository.getDetailRecentReleaseAnime(id, anime, isFavorite)

    override fun getDetailPopularAnime(
        id: Long,
        anime: String,
        isFavorite: Boolean,
    ): Flow<Resource<Anime>> =
        animeRepository.getDetailPopularAnime(id, anime, isFavorite)

    override fun getDetailTopAiringAnime(
        id: Long,
        anime: String,
        isFavorite: Boolean,
    ): Flow<Resource<Anime>> =
        animeRepository.getDetailTopAiringAnime(id, anime, isFavorite)
}