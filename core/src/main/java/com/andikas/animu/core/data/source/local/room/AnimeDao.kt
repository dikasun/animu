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
    @Query("SELECT * FROM recent_anime WHERE id = :id")
    fun getDetailRecentReleaseAnime(id: Long): Flow<RecentReleaseAnimeWithGenres>

    @Transaction
    @Query("SELECT * FROM popular_anime WHERE id = :id")
    fun getDetailPopularAnime(id: Long): Flow<PopularAnimeWithGenres>

    @Transaction
    @Query("SELECT * FROM top_air_anime WHERE id = :id")
    fun getDetailTopAiringAnime(id: Long): Flow<TopAirAnimeWithGenres>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecentReleaseAnime(animes: List<RecentReleaseAnimeEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPopularAnime(animes: List<PopularAnimeEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopAiringAnime(animes: List<TopAirAnimeEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecentReleaseAnimeGenres(genres: List<RecentReleaseAnimeGenreEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPopularAnimeGenres(genres: List<PopularAnimeGenreEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopAiringAnimeGenres(genres: List<TopAirAnimeGenreEntity>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateRecentReleaseAnime(anime: RecentReleaseAnimeEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updatePopularAnime(anime: PopularAnimeEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateTopAiringAnime(anime: TopAirAnimeEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateRecentReleaseAnimeGenre(genre: List<RecentReleaseAnimeGenreEntity>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updatePopularAnimeGenre(genre: List<PopularAnimeGenreEntity>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateTopAiringAnimeGenre(genre: List<TopAirAnimeGenreEntity>)
}