package com.andikas.animu.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.andikas.animu.core.data.source.local.entity.*

@Database(
    entities = [
        RecentReleaseAnimeEntity::class,
        PopularAnimeEntity::class,
        TopAirAnimeEntity::class,
        RecentReleaseAnimeGenreEntity::class,
        PopularAnimeGenreEntity::class,
        TopAirAnimeGenreEntity::class,
    ],
    version = 1,
    exportSchema = false
)
abstract class AnimeDatabase : RoomDatabase() {

    abstract fun animeDao(): AnimeDao

}