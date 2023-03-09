package com.andikas.animu.core.utils

import com.andikas.animu.core.data.source.local.entity.*
import com.andikas.animu.core.data.source.remote.response.AnimeDetailResponse
import com.andikas.animu.core.data.source.remote.response.ListAnimeResponse
import com.andikas.animu.core.domain.model.Anime

object DataMapper {

    fun mapRecentReleaseAnimeResponseToEntities(input: ListAnimeResponse): List<RecentReleaseAnimeWithGenres> {
        val animeList = mutableListOf<RecentReleaseAnimeWithGenres>()
        input.map {
            val anime = RecentReleaseAnimeEntity(
                animeId = it.animeId,
                animeImg = it.animeImg,
                animeTitle = it.animeTitle,
            )
            val genre = listOf<RecentReleaseAnimeGenreEntity>()
            animeList.add(RecentReleaseAnimeWithGenres(anime, genre))
        }

        return animeList
    }

    fun mapPopularAnimeResponseToEntities(input: ListAnimeResponse): List<PopularAnimeWithGenres> {
        val animeList = mutableListOf<PopularAnimeWithGenres>()
        input.map {
            val anime = PopularAnimeEntity(
                animeId = it.animeId,
                animeImg = it.animeImg,
                animeTitle = it.animeTitle,
            )
            val genre = listOf<PopularAnimeGenreEntity>()
            animeList.add(PopularAnimeWithGenres(anime, genre))
        }

        return animeList
    }

    fun mapTopAirAnimeResponseToEntities(input: ListAnimeResponse): List<TopAirAnimeWithGenres> {
        val animeList = mutableListOf<TopAirAnimeWithGenres>()
        input.map {
            val anime = TopAirAnimeEntity(
                animeId = it.animeId,
                animeImg = it.animeImg,
                animeTitle = it.animeTitle,
            )
            val genre = listOf<TopAirAnimeGenreEntity>()
            animeList.add(TopAirAnimeWithGenres(anime, genre))
        }

        return animeList
    }

    fun mapDetailRecentReleaseAnimeResponseToEntities(
        id: Long,
        anime: String,
        input: AnimeDetailResponse
    ): RecentReleaseAnimeWithGenres =
        RecentReleaseAnimeWithGenres(
            anime = RecentReleaseAnimeEntity(
                id = id,
                animeId = anime,
                animeImg = input.animeImg,
                animeTitle = input.animeTitle,
                otherNames = input.otherNames,
                releasedDate = input.releasedDate,
                status = input.status,
                synopsis = input.synopsis,
                type = input.type,
            ),
            genres = input.genres.map { genre ->
                RecentReleaseAnimeGenreEntity(animeId = id, genre = genre)
            }
        )

    fun mapDetailPopularAnimeResponseToEntities(
        id: Long,
        anime: String,
        input: AnimeDetailResponse,
    ): PopularAnimeWithGenres =
        PopularAnimeWithGenres(
            anime = PopularAnimeEntity(
                id = id,
                animeId = anime,
                animeImg = input.animeImg,
                animeTitle = input.animeTitle,
                otherNames = input.otherNames,
                releasedDate = input.releasedDate,
                status = input.status,
                synopsis = input.synopsis,
                type = input.type,
            ),
            genres = input.genres.map { genre ->
                PopularAnimeGenreEntity(animeId = id, genre = genre)
            }
        )

    fun mapDetailTopAirAnimeResponseToEntities(
        id: Long,
        anime: String,
        input: AnimeDetailResponse,
    ): TopAirAnimeWithGenres =
        TopAirAnimeWithGenres(
            anime = TopAirAnimeEntity(
                id = id,
                animeId = anime,
                animeImg = input.animeImg,
                animeTitle = input.animeTitle,
                otherNames = input.otherNames,
                releasedDate = input.releasedDate,
                status = input.status,
                synopsis = input.synopsis,
                type = input.type,
            ),
            genres = input.genres.map { genre ->
                TopAirAnimeGenreEntity(animeId = id, genre = genre)
            }
        )

    fun mapRecentReleaseAnimeEntitiesToDomain(input: List<RecentReleaseAnimeWithGenres>): List<Anime> =
        input.map {
            Anime(
                id = it.anime.id,
                animeId = it.anime.animeId,
                animeImg = it.anime.animeImg,
                animeTitle = it.anime.animeTitle,
                otherNames = it.anime.otherNames ?: "",
                totalEpisodes = it.anime.totalEpisodes ?: "",
                genres = it.genres.map { genre -> genre.genre },
                status = it.anime.status ?: "",
                synopsis = it.anime.synopsis ?: "",
                releasedDate = it.anime.releasedDate ?: "",
                type = it.anime.type ?: "",
            )
        }

    fun mapPopularAnimeEntitiesToDomain(input: List<PopularAnimeWithGenres>): List<Anime> =
        input.map {
            Anime(
                id = it.anime.id,
                animeId = it.anime.animeId,
                animeImg = it.anime.animeImg,
                animeTitle = it.anime.animeTitle,
                otherNames = it.anime.otherNames ?: "",
                totalEpisodes = it.anime.totalEpisodes ?: "",
                genres = it.genres.map { genre -> genre.genre },
                status = it.anime.status ?: "",
                synopsis = it.anime.synopsis ?: "",
                releasedDate = it.anime.releasedDate ?: "",
                type = it.anime.type ?: "",
            )
        }

    fun mapTopAirAnimeEntitiesToDomain(input: List<TopAirAnimeWithGenres>): List<Anime> =
        input.map {
            Anime(
                id = it.anime.id,
                animeId = it.anime.animeId,
                animeImg = it.anime.animeImg,
                animeTitle = it.anime.animeTitle,
                otherNames = it.anime.otherNames ?: "",
                totalEpisodes = it.anime.totalEpisodes ?: "",
                genres = it.genres.map { genre -> genre.genre },
                status = it.anime.status ?: "",
                synopsis = it.anime.synopsis ?: "",
                releasedDate = it.anime.releasedDate ?: "",
                type = it.anime.type ?: "",
            )
        }

    fun mapDetailRecentReleaseAnimeEntitiesToDomain(input: RecentReleaseAnimeWithGenres): Anime =
            Anime(
                id = input.anime.id,
                animeId = input.anime.animeId,
                animeImg = input.anime.animeImg,
                animeTitle = input.anime.animeTitle,
                otherNames = input.anime.otherNames ?: "",
                totalEpisodes = input.anime.totalEpisodes ?: "",
                genres = input.genres.map { genre -> genre.genre },
                status = input.anime.status ?: "",
                synopsis = input.anime.synopsis ?: "",
                releasedDate = input.anime.releasedDate ?: "",
                type = input.anime.type ?: "",
            )

    fun mapDetailPopularAnimeEntitiesToDomain(input: PopularAnimeWithGenres): Anime =
            Anime(
                id = input.anime.id,
                animeId = input.anime.animeId,
                animeImg = input.anime.animeImg,
                animeTitle = input.anime.animeTitle,
                otherNames = input.anime.otherNames ?: "",
                totalEpisodes = input.anime.totalEpisodes ?: "",
                genres = input.genres.map { genre -> genre.genre },
                status = input.anime.status ?: "",
                synopsis = input.anime.synopsis ?: "",
                releasedDate = input.anime.releasedDate ?: "",
                type = input.anime.type ?: "",
            )

    fun mapDetailTopAirAnimeEntitiesToDomain(input: TopAirAnimeWithGenres): Anime =
            Anime(
                id = input.anime.id,
                animeId = input.anime.animeId,
                animeImg = input.anime.animeImg,
                animeTitle = input.anime.animeTitle,
                otherNames = input.anime.otherNames ?: "",
                totalEpisodes = input.anime.totalEpisodes ?: "",
                genres = input.genres.map { genre -> genre.genre },
                status = input.anime.status ?: "",
                synopsis = input.anime.synopsis ?: "",
                releasedDate = input.anime.releasedDate ?: "",
                type = input.anime.type ?: "",
            )

    fun mapRecentReleaseAnimeDomainToEntity(
        id: Long,
        input: Anime,
    ): RecentReleaseAnimeWithGenres =
        RecentReleaseAnimeWithGenres(
            anime = RecentReleaseAnimeEntity(
                animeId = input.animeId,
                animeImg = input.animeImg,
                animeTitle = input.animeTitle,
                otherNames = input.otherNames,
                totalEpisodes = input.totalEpisodes,
                status = input.status,
                synopsis = input.synopsis,
                releasedDate = input.releasedDate,
                type = input.type
            ),
            genres = input.genres.map { genre ->
                RecentReleaseAnimeGenreEntity(animeId = id, genre = genre)
            }
        )

    fun mapPopularAnimeDomainToEntity(
        id: Long,
        input: Anime,
    ): PopularAnimeWithGenres =
        PopularAnimeWithGenres(
            anime = PopularAnimeEntity(
                animeId = input.animeId,
                animeImg = input.animeImg,
                animeTitle = input.animeTitle,
                otherNames = input.otherNames,
                totalEpisodes = input.totalEpisodes,
                status = input.status,
                synopsis = input.synopsis,
                releasedDate = input.releasedDate,
                type = input.type
            ),
            genres = input.genres.map { genre ->
                PopularAnimeGenreEntity(animeId = id, genre = genre)
            }
        )

    fun mapTopAirAnimeDomainToEntity(
        id: Long,
        input: Anime,
    ): TopAirAnimeWithGenres = TopAirAnimeWithGenres(
        anime = TopAirAnimeEntity(
            animeId = input.animeId,
            animeImg = input.animeImg,
            animeTitle = input.animeTitle,
            otherNames = input.otherNames,
            totalEpisodes = input.totalEpisodes,
            status = input.status,
            synopsis = input.synopsis,
            releasedDate = input.releasedDate,
            type = input.type
        ),
        genres = input.genres.map { genre ->
            TopAirAnimeGenreEntity(animeId = id, genre = genre)
        }
    )
}