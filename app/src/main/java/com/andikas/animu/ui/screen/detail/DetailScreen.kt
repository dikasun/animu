package com.andikas.animu.ui.screen.detail

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.andikas.animu.R
import com.andikas.animu.core.data.Resource
import com.andikas.animu.core.domain.model.Anime
import com.andikas.animu.ui.common.AnimeType
import com.andikas.animu.ui.components.BackButton
import com.andikas.animu.ui.components.ErrorSection
import com.andikas.animu.ui.components.LoadingSection
import com.andikas.animu.ui.components.ShortFavoriteButton
import com.andikas.animu.ui.theme.Poppins
import org.koin.androidx.compose.getViewModel

@Composable
fun DetailScreen(
    id: Long,
    animeId: String,
    animeType: String,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: DetailViewModel = getViewModel(),
) {
    LaunchedEffect(true) {
        when (AnimeType.valueOf(animeType)) {
            AnimeType.RECENT_RELEASE -> viewModel.recentReleaseAnimeDetail(id, animeId)
            AnimeType.POPULAR -> viewModel.popularAnimeDetail(id, animeId)
            AnimeType.TOP_AIR -> viewModel.topAirAnimeDetail(id, animeId)
        }
    }

    viewModel.uiState.collectAsState(initial = Resource.Loading()).value.let { resource ->
        when (resource) {
            is Resource.Loading -> LoadingSection()
            is Resource.Success -> resource.data?.let {
                DetailContent(
                    anime = it,
                    navigateBack = navigateBack,
                    modifier = modifier,
                )
            }
            else ->
                ErrorSection(message = resource.message.toString())
        }
    }
}

@Composable
fun DetailContent(
    anime: Anime,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            SubcomposeAsyncImage(
                model = anime.animeImg,
                loading = {
                    LoadingSection()
                },
                contentScale = ContentScale.Crop,
                contentDescription = null,
                colorFilter = ColorFilter.tint(
                    color = Color.LightGray,
                    blendMode = BlendMode.Multiply
                ),
                modifier = Modifier
                    .height(420.dp)
                    .fillMaxWidth(),
            )
            BackButton(
                navigateBack = navigateBack,
                modifier = Modifier
                    .padding(12.dp)
                    .align(Alignment.TopStart),
            )

        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Text(
                    text = anime.animeTitle,
                    color = Color.White,
                    fontSize = 32.sp,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .weight(3f),
                )
                ShortFavoriteButton(
                    isFavorite = false,
                    onClick = { },
                    modifier = Modifier
                        .weight(1f),
                )
            }
            Text(
                text = anime.otherNames,
                color = Color.White,
                fontSize = 18.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(top = 4.dp),
            )
            Row(
                modifier = Modifier
                    .padding(top = 6.dp)
            ) {
                Text(
                    text = "${anime.releasedDate} | ",
                    color = Color.White,
                    fontSize = 14.sp,
                    fontFamily = Poppins,
                )
                Text(
                    text = anime.type,
                    color = colorResource(id = R.color.color_primary),
                    fontSize = 14.sp,
                    fontFamily = Poppins,
                    modifier = Modifier
                        .border(
                            width = 1.dp,
                            color = colorResource(id = R.color.color_primary),
                            shape = RoundedCornerShape(4.dp),
                        )
                        .padding(horizontal = 4.dp),
                )
                Text(
                    text = anime.status,
                    color = colorResource(id = R.color.color_primary),
                    fontSize = 14.sp,
                    fontFamily = Poppins,
                    modifier = Modifier
                        .border(
                            width = 1.dp,
                            color = colorResource(id = R.color.color_primary),
                            shape = RoundedCornerShape(4.dp),
                        )
                        .padding(horizontal = 4.dp),
                )
            }
            Text(
                text = "Genre : ${anime.genres.joinToString()}",
                color = Color.White,
                fontSize = 14.sp,
                fontFamily = Poppins,
                modifier = Modifier
                    .padding(top = 8.dp),
            )
            Text(
                text = anime.synopsis,
                color = Color.White,
                fontSize = 14.sp,
                fontFamily = Poppins,
                modifier = Modifier
                    .padding(top = 16.dp),
            )
        }
    }
}