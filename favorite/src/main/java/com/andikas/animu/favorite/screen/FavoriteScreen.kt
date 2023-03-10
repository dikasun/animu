package com.andikas.animu.favorite.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andikas.animu.core.domain.model.Anime
import com.andikas.animu.ui.common.AnimeType
import com.andikas.animu.ui.components.AnimeDetailItem
import com.andikas.animu.ui.components.BackButton
import com.andikas.animu.ui.theme.Poppins
import org.koin.androidx.compose.getViewModel

@Composable
fun FavoriteScreen(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: FavoriteViewModel = getViewModel(),
) {
    viewModel.favoriteRecentReleaseAnime.collectAsState(initial = listOf()).value.let {
        viewModel.favoriteRecentReleaseAnimeState.value = it
        FavoriteContent(
            topAirAnime = viewModel.favoriteTopAirAnimeState.value,
            popularAnime = viewModel.favoritePopularAnimeState.value,
            recentReleaseAnime = viewModel.favoriteRecentReleaseAnimeState.value,
            navigateBack = navigateBack,
            navigateToDetail = { _, _, _, _ -> },
            onTopAirAnimeFavoriteClick = viewModel::setFavoriteTopAiringAnime,
            onPopularAnimeFavoriteClick = viewModel::setFavoritePopularAnime,
            onRecentReleaseAnimeFavoriteClick = viewModel::setFavoriteRecentReleaseAnime,
            modifier = modifier,
        )
    }
    viewModel.favoritePopularAnime.collectAsState(initial = listOf()).value.let {
        viewModel.favoritePopularAnimeState.value = it
        FavoriteContent(
            topAirAnime = viewModel.favoriteTopAirAnimeState.value,
            popularAnime = viewModel.favoritePopularAnimeState.value,
            recentReleaseAnime = viewModel.favoriteRecentReleaseAnimeState.value,
            navigateBack = navigateBack,
            navigateToDetail = { _, _, _, _ -> },
            onTopAirAnimeFavoriteClick = viewModel::setFavoriteTopAiringAnime,
            onPopularAnimeFavoriteClick = viewModel::setFavoritePopularAnime,
            onRecentReleaseAnimeFavoriteClick = viewModel::setFavoriteRecentReleaseAnime,
            modifier = modifier,
        )
    }
    viewModel.favoriteTopAirAnime.collectAsState(initial = listOf()).value.let {
        viewModel.favoriteTopAirAnimeState.value = it
        FavoriteContent(
            topAirAnime = viewModel.favoriteTopAirAnimeState.value,
            popularAnime = viewModel.favoritePopularAnimeState.value,
            recentReleaseAnime = viewModel.favoriteRecentReleaseAnimeState.value,
            navigateBack = navigateBack,
            navigateToDetail = { _, _, _, _ -> },
            onTopAirAnimeFavoriteClick = viewModel::setFavoriteTopAiringAnime,
            onPopularAnimeFavoriteClick = viewModel::setFavoritePopularAnime,
            onRecentReleaseAnimeFavoriteClick = viewModel::setFavoriteRecentReleaseAnime,
            modifier = modifier,
        )
    }
}

@Composable
fun FavoriteContent(
    topAirAnime: List<Anime>,
    popularAnime: List<Anime>,
    recentReleaseAnime: List<Anime>,
    navigateBack: () -> Unit,
    navigateToDetail: (
        animeId: String,
        id: Long,
        type: String,
        favorite: Boolean,
    ) -> Unit,
    onTopAirAnimeFavoriteClick: (
        anime: Anime,
        isFavorite: Boolean,
    ) -> Unit,
    onPopularAnimeFavoriteClick: (
        anime: Anime,
        isFavorite: Boolean,
    ) -> Unit,
    onRecentReleaseAnimeFavoriteClick: (
        anime: Anime,
        isFavorite: Boolean,
    ) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(20.dp),
    ) {
        item {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(top = 30.dp)
            ) {
                BackButton(
                    navigateBack = navigateBack,
                )
                Text(
                    text = "Favorite",
                    color = Color.White,
                    fontSize = 32.sp,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 16.dp)
                )
            }
        }
        if (topAirAnime.isNotEmpty()) {
            item {
                Text(
                    text = "Top Airing",
                    fontSize = 24.sp,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .padding(
                            top = 32.dp,
                        ),
                )
            }
            items(topAirAnime, key = { "top_air_${it.id}" }) {
                AnimeDetailItem(
                    id = it.id,
                    animeId = it.animeId,
                    animeType = AnimeType.TOP_AIR.name,
                    image = it.animeImg,
                    title = it.animeTitle,
                    releaseDate = it.releasedDate,
                    type = it.type,
                    genre = it.genres.joinToString(),
                    isFavorite = it.isFavorite,
                    navigateToDetail = navigateToDetail,
                    onFavoriteClick = { favorite ->
                        onTopAirAnimeFavoriteClick(it, favorite)
                    },
                )
            }
        }
        if (popularAnime.isNotEmpty()) {
            item {
                Text(
                    text = "Popular",
                    fontSize = 24.sp,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .padding(
                            top = 32.dp,
                        ),
                )
            }
            items(popularAnime, key = { "popular_${it.id}" }) {
                AnimeDetailItem(
                    id = it.id,
                    animeId = it.animeId,
                    animeType = AnimeType.TOP_AIR.name,
                    image = it.animeImg,
                    title = it.animeTitle,
                    releaseDate = it.releasedDate,
                    type = it.type,
                    genre = it.genres.joinToString(),
                    isFavorite = it.isFavorite,
                    navigateToDetail = navigateToDetail,
                    onFavoriteClick = { favorite ->
                        onPopularAnimeFavoriteClick(it, favorite)
                    },
                )
            }
        }
        if (recentReleaseAnime.isNotEmpty()) {
            item {
                Text(
                    text = "Recent Release",
                    fontSize = 24.sp,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .padding(
                            top = 32.dp,
                        ),
                )
            }
            items(recentReleaseAnime, key = { "recent_${it.id}" }) {
                AnimeDetailItem(
                    id = it.id,
                    animeId = it.animeId,
                    animeType = AnimeType.TOP_AIR.name,
                    image = it.animeImg,
                    title = it.animeTitle,
                    releaseDate = it.releasedDate,
                    type = it.type,
                    genre = it.genres.joinToString(),
                    isFavorite = it.isFavorite,
                    navigateToDetail = navigateToDetail,
                    onFavoriteClick = { favorite ->
                        onRecentReleaseAnimeFavoriteClick(it, favorite)
                    },
                )
            }
        }
    }
}