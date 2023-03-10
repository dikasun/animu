package com.andikas.animu.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andikas.animu.R
import com.andikas.animu.core.data.Resource
import com.andikas.animu.core.domain.model.Anime
import com.andikas.animu.ui.common.AnimeType
import com.andikas.animu.ui.components.AnimeBannerItem
import com.andikas.animu.ui.components.AnimeItem
import com.andikas.animu.ui.components.ErrorSection
import com.andikas.animu.ui.components.LoadingSection
import com.andikas.animu.ui.theme.Poppins
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(
    navigateToFavorite: () -> Unit,
    navigateToDetail: (
        animeId: String,
        id: Long,
        type: String,
        favorite: Boolean,
    ) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = getViewModel(),
) {
    viewModel.recentReleaseAnime.collectAsState(initial = Resource.Loading()).value.let { resource ->
        when (resource) {
            is Resource.Loading -> LoadingSection()
            is Resource.Success -> {
                viewModel.recentReleaseAnimeState.value = resource.data as List<Anime>
                HomeContent(
                    modifier = modifier,
                    recentReleaseAnime = viewModel.recentReleaseAnimeState.value,
                    popularAnime = viewModel.popularAnimeState.value,
                    topAirAnime = viewModel.topAirAnimeState.value,
                    navigateToFavorite = navigateToFavorite,
                    navigateToDetail = navigateToDetail,
                )
            }
            else ->
                ErrorSection(message = resource.message.toString())
        }
    }
    viewModel.popularAnime.collectAsState(initial = Resource.Loading()).value.let { resource ->
        when (resource) {
            is Resource.Loading -> LoadingSection()
            is Resource.Success -> {
                viewModel.popularAnimeState.value = resource.data as List<Anime>
                HomeContent(
                    modifier = modifier,
                    recentReleaseAnime = viewModel.recentReleaseAnimeState.value,
                    popularAnime = viewModel.popularAnimeState.value,
                    topAirAnime = viewModel.topAirAnimeState.value,
                    navigateToFavorite = navigateToFavorite,
                    navigateToDetail = navigateToDetail,
                )
            }
            else ->
                ErrorSection(message = resource.message.toString())
        }
    }
    viewModel.topAirAnime.collectAsState(initial = Resource.Loading()).value.let { resource ->
        when (resource) {
            is Resource.Loading -> LoadingSection()
            is Resource.Success -> {
                viewModel.topAirAnimeState.value = resource.data as List<Anime>
                HomeContent(
                    modifier = modifier,
                    recentReleaseAnime = viewModel.recentReleaseAnimeState.value,
                    popularAnime = viewModel.popularAnimeState.value,
                    topAirAnime = viewModel.topAirAnimeState.value,
                    navigateToFavorite = navigateToFavorite,
                    navigateToDetail = navigateToDetail,
                )
            }
            else ->
                ErrorSection(message = resource.message.toString())
        }
    }
}

@Composable
fun HomeContent(
    recentReleaseAnime: List<Anime>,
    popularAnime: List<Anime>,
    topAirAnime: List<Anime>,
    navigateToFavorite: () -> Unit,
    navigateToDetail: (
        animeId: String,
        id: Long,
        type: String,
        favorite: Boolean,
    ) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState()),
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 30.dp)
                    .size(28.dp),
            )
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.color_primary),
                    contentColor = Color.White
                ),
                onClick = navigateToFavorite,
                modifier = Modifier
                    .padding(top = 30.dp)
                    .clip(CircleShape),
            ) {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    tint = Color.White,
                    contentDescription = "See Favorite",
                )
            }
        }
        LazyRow(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth(),
        ) {
            items(topAirAnime, key = { it.id }) {
                AnimeBannerItem(
                    id = it.id,
                    animeId = it.animeId,
                    type = AnimeType.TOP_AIR.name,
                    image = it.animeImg,
                    isFavorite = it.isFavorite,
                    navigateToDetail = navigateToDetail
                )
            }
        }
        Text(
            text = "Popular Anime",
            color = Color.White,
            fontSize = 18.sp,
            fontFamily = Poppins,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .padding(
                    start = 20.dp,
                    top = 30.dp,
                    end = 20.dp,
                    bottom = 20.dp,
                )
                .fillMaxWidth(),
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .padding(
                    horizontal = 20.dp,
                    vertical = 12.dp,
                ),
        ) {
            items(popularAnime, key = { it.id }) {
                AnimeItem(
                    id = it.id,
                    animeId = it.animeId,
                    type = AnimeType.POPULAR.name,
                    image = it.animeImg,
                    isFavorite = it.isFavorite,
                    navigateToDetail = navigateToDetail
                )
            }
        }
        Text(
            text = "Recent Release Anime",
            color = Color.White,
            fontSize = 18.sp,
            fontFamily = Poppins,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .padding(
                    horizontal = 20.dp,
                    vertical = 20.dp,
                )
                .fillMaxWidth(),
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .padding(
                    start = 20.dp,
                    top = 12.dp,
                    end = 20.dp,
                    bottom = 50.dp,
                ),
        ) {
            items(recentReleaseAnime, key = { it.id }) {
                AnimeItem(
                    id = it.id,
                    animeId = it.animeId,
                    type = AnimeType.RECENT_RELEASE.name,
                    image = it.animeImg,
                    isFavorite = it.isFavorite,
                    navigateToDetail = navigateToDetail
                )
            }
        }
    }
}