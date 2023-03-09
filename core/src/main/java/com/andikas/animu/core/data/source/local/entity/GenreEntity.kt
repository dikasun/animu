package com.andikas.animu.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recent_anime_genre")
data class RecentReleaseAnimeGenreEntity(
    @PrimaryKey
    @ColumnInfo(name = "genre")
    var genre: String,

    @ColumnInfo(name = "animeId")
    var animeId: Long,
)

@Entity(tableName = "popular_anime_genre")
data class PopularAnimeGenreEntity(
    @PrimaryKey
    @ColumnInfo(name = "genre")
    var genre: String,

    @ColumnInfo(name = "animeId")
    var animeId: Long,
)

@Entity(tableName = "top_air_anime_genre")
data class TopAirAnimeGenreEntity(
    @PrimaryKey
    @ColumnInfo(name = "genre")
    var genre: String,

    @ColumnInfo(name = "animeId")
    var animeId: Long,
)
