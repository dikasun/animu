package com.andikas.animu.core.data.source.local.entity

import androidx.room.*

@Entity(tableName = "popular_anime")
data class PopularAnimeEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0,

    @ColumnInfo(name = "animeId")
    var animeId: String,

    @ColumnInfo(name = "animeImg")
    var animeImg: String,

    @ColumnInfo(name = "animeTitle")
    var animeTitle: String,

    @ColumnInfo(name = "otherNames")
    var otherNames: String? = null,

    @ColumnInfo(name = "totalEpisodes")
    var totalEpisodes: String? = null,

    @ColumnInfo(name = "status")
    var status: String? = null,

    @ColumnInfo(name = "synopsis")
    var synopsis: String? = null,

    @ColumnInfo(name = "releasedDate")
    var releasedDate: String? = null,

    @ColumnInfo(name = "type")
    var type: String? = null,
)

data class PopularAnimeWithGenres(
    @Embedded
    var anime: PopularAnimeEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "animeId"
    )
    var genres: List<PopularAnimeGenreEntity>
)
