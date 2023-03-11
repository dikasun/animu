package com.andikas.animu.core.data.source.local.entity

import androidx.room.*

@Entity(
    tableName = "recent_anime",
    indices = [
        Index(
            value = ["animeId"],
            unique = true,
        )
    ]
)
data class RecentReleaseAnimeEntity(
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

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean,
)

data class RecentReleaseAnimeWithGenres(
    @Embedded
    var anime: RecentReleaseAnimeEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "animeId"
    )
    var genres: List<RecentReleaseAnimeGenreEntity>
)
