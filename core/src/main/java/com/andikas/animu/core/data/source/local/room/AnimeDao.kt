package com.andikas.animu.core.data.source.local.room

import androidx.room.*
import com.andikas.animu.core.data.source.local.entity.*
import kotlinx.coroutines.flow.Flow

@Dao
interface AnimeDao {

    @Transaction
    @Query("SELECT * FROM recent_anime")
    fun getRecentReleaseAnime(): Flow<List<RecentReleaseAnimeWithGenres>>

    @Transaction
    @Query("SELECT * FROM popular_anime")
    fun getPopularAnime(): Flow<List<PopularAnimeWithGenres>>

    @Transaction
    @Query("SELECT * FROM top_air_anime")
    fun getTopAiringAnime(): Flow<List<TopAirAnimeWithGenres>>

    @Transaction
    @Query("SELECT * FROM recent_anime WHERE isFavorite = 1")
    fun getFavoriteRecentReleaseAnime(): Flow<List<RecentReleaseAnimeWithGenres>>

    @Transaction
    @Query("SELECT * FROM popular_anime WHERE isFavorite = 1")
    fun getFavoritePopularAnime(): Flow<List<PopularAnimeWithGenres>>

    @Transaction
    @Query("SELECT * FROM top_air_anime WHERE isFavorite = 1")
    fun getFavoriteTopAiringAnime(): Flow<List<TopAirAnimeWithGenres>>

    @Transaction
    @Query("SELECT * FROM recent_anime WHERE id = :id")
    fun getDetailRecentReleaseAnime(id: Long): Flow<RecentReleaseAnimeWithGenres>

    @Transaction
    @Query("SELECT * FROM popular_anime WHERE id = :id")
    fun getDetailPopularAnime(id: Long): Flow<PopularAnimeWithGenres>

    @Transaction
    @Query("SELECT * FROM top_air_anime WHERE id = :id")
    fun getDetailTopAiringAnime(id: Long): Flow<TopAirAnimeWithGenres>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertRecentReleaseAnime(animes: List<RecentReleaseAnimeEntity>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPopularAnime(animes: List<PopularAnimeEntity>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTopAiringAnime(animes: List<TopAirAnimeEntity>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertRecentReleaseAnimeGenres(genres: List<RecentReleaseAnimeGenreEntity>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPopularAnimeGenres(genres: List<PopularAnimeGenreEntity>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTopAiringAnimeGenres(genres: List<TopAirAnimeGenreEntity>)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateRecentReleaseAnime(anime: RecentReleaseAnimeEntity)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updatePopularAnime(anime: PopularAnimeEntity)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateTopAiringAnime(anime: TopAirAnimeEntity)
}