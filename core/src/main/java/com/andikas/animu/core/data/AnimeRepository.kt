package com.andikas.animu.core.data

import com.andikas.animu.core.data.source.local.LocalDataSource
import com.andikas.animu.core.data.source.remote.RemoteDataSource
import com.andikas.animu.core.data.source.remote.network.ApiResponse
import com.andikas.animu.core.data.source.remote.response.AnimeDetailResponse
import com.andikas.animu.core.data.source.remote.response.ListAnimeResponse
import com.andikas.animu.core.domain.model.Anime
import com.andikas.animu.core.domain.repository.IAnimeRepository
import com.andikas.animu.core.utils.AppExecutors
import com.andikas.animu.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AnimeRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val appExecutors: AppExecutors,
) : IAnimeRepository {

    override fun getRecentReleaseAnime(): Flow<Resource<List<Anime>>> =
        object : NetworkBoundResource<List<Anime>, ListAnimeResponse>() {
            override fun loadFromDB(): Flow<List<Anime>> {
                return localDataSource.getRecentReleaseAnime().map {
                    DataMapper.mapRecentReleaseAnimeEntitiesToDomain(it)
                }
            }

            override suspend fun createCall(): Flow<ApiResponse<ListAnimeResponse>> {
                return remoteDataSource.getRecentReleaseAnime()
            }

            override suspend fun saveCallResult(data: ListAnimeResponse) {
                val animeList = DataMapper.mapRecentReleaseAnimeResponseToEntities(data)
                localDataSource.insertRecentReleaseAnime(animeList.map { it.anime })
                animeList.map { localDataSource.insertRecentReleaseAnimeGenres(it.genres) }
            }

            override fun shouldFetch(data: List<Anime>?): Boolean {
                return true
            }
        }.asFlow()

    override fun getPopularAnime(): Flow<Resource<List<Anime>>> =
        object : NetworkBoundResource<List<Anime>, ListAnimeResponse>() {
            override fun loadFromDB(): Flow<List<Anime>> {
                return localDataSource.getPopularAnime().map {
                    DataMapper.mapPopularAnimeEntitiesToDomain(it)
                }
            }

            override suspend fun createCall(): Flow<ApiResponse<ListAnimeResponse>> {
                return remoteDataSource.getPopularAnime()
            }

            override suspend fun saveCallResult(data: ListAnimeResponse) {
                val animeList = DataMapper.mapPopularAnimeResponseToEntities(data)
                localDataSource.insertPopularAnime(animeList.map { it.anime })
                animeList.map { localDataSource.insertPopularAnimeGenres(it.genres) }
            }

            override fun shouldFetch(data: List<Anime>?): Boolean {
                return true
            }
        }.asFlow()

    override fun getTopAiringAnime(): Flow<Resource<List<Anime>>> =
        object : NetworkBoundResource<List<Anime>, ListAnimeResponse>() {
            override fun loadFromDB(): Flow<List<Anime>> {
                return localDataSource.getTopAiringAnime().map {
                    DataMapper.mapTopAirAnimeEntitiesToDomain(it)
                }
            }

            override suspend fun createCall(): Flow<ApiResponse<ListAnimeResponse>> {
                return remoteDataSource.getTopAiringAnime()
            }

            override suspend fun saveCallResult(data: ListAnimeResponse) {
                val animeList = DataMapper.mapTopAirAnimeResponseToEntities(data)
                localDataSource.insertTopAiringAnime(animeList.map { it.anime })
                animeList.map { localDataSource.insertTopAiringAnimeGenres(it.genres) }
            }

            override fun shouldFetch(data: List<Anime>?): Boolean {
                return true
            }
        }.asFlow()

    override fun getFavoriteRecentReleaseAnime(): Flow<List<Anime>> {
        return localDataSource.getFavoriteRecentReleaseAnime().map {
            DataMapper.mapRecentReleaseAnimeEntitiesToDomain(it)
        }
    }

    override suspend fun setFavoriteRecentReleaseAnime(anime: Anime, state: Boolean) {
        val animeEntity = DataMapper.mapRecentReleaseAnimeDomainToEntity(anime)
        animeEntity.anime.isFavorite = state
        localDataSource.updateRecentReleaseAnime(animeEntity.anime)
    }

    override fun getFavoritePopularAnime(): Flow<List<Anime>> {
        return localDataSource.getFavoritePopularAnime().map {
            DataMapper.mapPopularAnimeEntitiesToDomain(it)
        }
    }

    override suspend fun setFavoritePopularAnime(anime: Anime, state: Boolean) {
        val animeEntity = DataMapper.mapPopularAnimeDomainToEntity(anime)
        animeEntity.anime.isFavorite = state
        localDataSource.updatePopularAnime(animeEntity.anime)
    }

    override fun getFavoriteTopAiringAnime(): Flow<List<Anime>> {
        return localDataSource.getFavoriteTopAiringAnime().map {
            DataMapper.mapTopAirAnimeEntitiesToDomain(it)
        }
    }

    override suspend fun setFavoriteTopAiringAnime(anime: Anime, state: Boolean) {
        val animeEntity = DataMapper.mapTopAirAnimeDomainToEntity(anime)
        animeEntity.anime.isFavorite = state
        localDataSource.updateTopAiringAnime(animeEntity.anime)
    }

    override fun getDetailRecentReleaseAnime(
        id: Long,
        anime: String,
        isFavorite: Boolean
    ): Flow<Resource<Anime>> =
        object : NetworkBoundResource<Anime, AnimeDetailResponse>() {
            override fun loadFromDB(): Flow<Anime> {
                return localDataSource.getDetailRecentReleaseAnime(id).map {
                    DataMapper.mapDetailRecentReleaseAnimeEntitiesToDomain(it)
                }
            }

            override suspend fun createCall(): Flow<ApiResponse<AnimeDetailResponse>> {
                return remoteDataSource.getDetailAnime(anime)
            }

            override suspend fun saveCallResult(data: AnimeDetailResponse) {
                val mAnime = DataMapper.mapDetailRecentReleaseAnimeResponseToEntity(
                    id, anime, isFavorite, data
                )
                localDataSource.updateRecentReleaseAnime(mAnime.anime)
                localDataSource.insertRecentReleaseAnimeGenres(mAnime.genres)
            }

            override fun shouldFetch(data: Anime?): Boolean {
                return true
            }
        }.asFlow()

    override fun getDetailPopularAnime(
        id: Long,
        anime: String,
        isFavorite: Boolean
    ): Flow<Resource<Anime>> =
        object : NetworkBoundResource<Anime, AnimeDetailResponse>() {
            override fun loadFromDB(): Flow<Anime> {
                return localDataSource.getDetailPopularAnime(id).map {
                    DataMapper.mapDetailPopularAnimeEntitiesToDomain(it)
                }
            }

            override suspend fun createCall(): Flow<ApiResponse<AnimeDetailResponse>> {
                return remoteDataSource.getDetailAnime(anime)
            }

            override suspend fun saveCallResult(data: AnimeDetailResponse) {
                val mAnime = DataMapper.mapDetailPopularAnimeResponseToEntity(
                    id, anime, isFavorite, data
                )
                localDataSource.updatePopularAnime(mAnime.anime)
                localDataSource.insertPopularAnimeGenres(mAnime.genres)
            }

            override fun shouldFetch(data: Anime?): Boolean {
                return true
            }
        }.asFlow()

    override fun getDetailTopAiringAnime(
        id: Long,
        anime: String,
        isFavorite: Boolean
    ): Flow<Resource<Anime>> =
        object : NetworkBoundResource<Anime, AnimeDetailResponse>() {
            override fun loadFromDB(): Flow<Anime> {
                return localDataSource.getDetailTopAiringAnime(id).map {
                    DataMapper.mapDetailTopAirAnimeEntitiesToDomain(it)
                }
            }

            override suspend fun createCall(): Flow<ApiResponse<AnimeDetailResponse>> {
                return remoteDataSource.getDetailAnime(anime)
            }

            override suspend fun saveCallResult(data: AnimeDetailResponse) {
                val mAnime = DataMapper.mapDetailTopAirAnimeResponseToEntity(
                    id, anime, isFavorite, data
                )
                localDataSource.updateTopAiringAnime(mAnime.anime)
                localDataSource.insertTopAiringAnimeGenres(mAnime.genres)
            }

            override fun shouldFetch(data: Anime?): Boolean {
                return true
            }
        }.asFlow()
}