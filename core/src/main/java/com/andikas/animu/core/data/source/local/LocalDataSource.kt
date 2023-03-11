package com.andikas.animu.core.data.source.local

import com.andikas.animu.core.data.source.local.entity.*
import com.andikas.animu.core.data.source.local.room.AnimeDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val animeDao: AnimeDao) {

    fun getRecentReleaseAnime(): Flow<List<RecentReleaseAnimeWithGenres>> =
        animeDao.getRecentReleaseAnime()

    fun getPopularAnime(): Flow<List<PopularAnimeWithGenres>> =
        animeDao.getPopularAnime()

    fun getTopAiringAnime(): Flow<List<TopAirAnimeWithGenres>> =
        animeDao.getTopAiringAnime()

    fun getFavoriteRecentReleaseAnime(): Flow<List<RecentReleaseAnimeWithGenres>> =
        animeDao.getFavoriteRecentReleaseAnime()

    fun getFavoritePopularAnime(): Flow<List<PopularAnimeWithGenres>> =
        animeDao.getFavoritePopularAnime()

    fun getFavoriteTopAiringAnime(): Flow<List<TopAirAnimeWithGenres>> =
        animeDao.getFavoriteTopAiringAnime()

    fun getDetailRecentReleaseAnime(id: Long): Flow<RecentReleaseAnimeWithGenres> =
        animeDao.getDetailRecentReleaseAnime(id)

    fun getDetailPopularAnime(id: Long): Flow<PopularAnimeWithGenres> =
        animeDao.getDetailPopularAnime(id)

    fun getDetailTopAiringAnime(id: Long): Flow<TopAirAnimeWithGenres> =
        animeDao.getDetailTopAiringAnime(id)

    suspend fun insertRecentReleaseAnime(animes: List<RecentReleaseAnimeEntity>) =
        animeDao.insertRecentReleaseAnime(animes)

    suspend fun insertPopularAnime(animes: List<PopularAnimeEntity>) =
        animeDao.insertPopularAnime(animes)

    suspend fun insertTopAiringAnime(animes: List<TopAirAnimeEntity>) =
        animeDao.insertTopAiringAnime(animes)

    suspend fun insertRecentReleaseAnimeGenres(genres: List<RecentReleaseAnimeGenreEntity>) =
        animeDao.insertRecentReleaseAnimeGenres(genres)

    suspend fun insertPopularAnimeGenres(genres: List<PopularAnimeGenreEntity>) =
        animeDao.insertPopularAnimeGenres(genres)

    suspend fun insertTopAiringAnimeGenres(genres: List<TopAirAnimeGenreEntity>) =
        animeDao.insertTopAiringAnimeGenres(genres)

    suspend fun updateRecentReleaseAnime(anime: RecentReleaseAnimeEntity) =
        animeDao.updateRecentReleaseAnime(anime)

    suspend fun updatePopularAnime(anime: PopularAnimeEntity) =
        animeDao.updatePopularAnime(anime)

    suspend fun updateTopAiringAnime(anime: TopAirAnimeEntity) =
        animeDao.updateTopAiringAnime(anime)
}