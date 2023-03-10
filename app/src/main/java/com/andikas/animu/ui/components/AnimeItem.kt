package com.andikas.animu.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.andikas.animu.ui.theme.AnimuTheme
import com.andikas.animu.ui.theme.Poppins

@Composable
fun AnimeItem(
    id: Long,
    animeId: String,
    type: String,
    image: String,
    isFavorite: Boolean,
    navigateToDetail: (
        animeId: String,
        id: Long,
        type: String,
        favorite: Boolean,
    ) -> Unit,
    modifier: Modifier = Modifier,
) {
    SubcomposeAsyncImage(
        model = image,
        loading = {
            LoadingSection()
        },
        contentScale = ContentScale.Crop,
        contentDescription = null,
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .height(210.dp)
            .width(150.dp)
            .clickable { navigateToDetail(animeId, id, type, isFavorite) },
    )
}

@Composable
fun AnimeBannerItem(
    id: Long,
    animeId: String,
    type: String,
    image: String,
    isFavorite: Boolean,
    navigateToDetail: (
        animeId: String,
        id: Long,
        type: String,
        favorite: Boolean,
    ) -> Unit,
    modifier: Modifier = Modifier,
) {
    SubcomposeAsyncImage(
        model = image,
        loading = {
            LoadingSection()
        },
        contentScale = ContentScale.Crop,
        contentDescription = null,
        modifier = modifier
            .height(420.dp)
            .width(640.dp)
            .clickable { navigateToDetail(animeId, id, type, isFavorite) },
    )
}

@Composable
fun AnimeDetailItem(
    id: Long,
    animeId: String,
    animeType: String,
    image: String,
    title: String,
    releaseDate: String,
    type: String,
    genre: String,
    isFavorite: Boolean,
    navigateToDetail: (
        animeId: String,
        id: Long,
        type: String,
        favorite: Boolean,
    ) -> Unit,
    onFavoriteClick: (favorite: Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    var setFavorite by remember { mutableStateOf(isFavorite) }

    Row(
        modifier = modifier
            .height(210.dp)
            .fillMaxWidth()
            .clickable { navigateToDetail(animeId, id, animeType, setFavorite) }
    ) {
        SubcomposeAsyncImage(
            model = image,
            loading = {
                LoadingSection()
            },
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .clip(RoundedCornerShape(12.dp))
                .width(150.dp),
        )
        Column(
            modifier = Modifier
                .padding(12.dp),
        ) {
            Column(
                modifier = Modifier
                    .weight(1f),
            ) {
                Text(
                    text = title,
                    fontSize = 24.sp,
                    fontFamily = Poppins,
                    color = Color.White,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.SemiBold,
                )
                Text(
                    text = "$releaseDate | $type",
                    fontSize = 18.sp,
                    fontFamily = Poppins,
                    color = Color.White,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .padding(top = 8.dp),
                )
                Text(
                    text = genre,
                    fontSize = 18.sp,
                    fontFamily = Poppins,
                    color = Color.White,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .padding(top = 8.dp),
                )
            }
            FavoriteButton(
                isFavorite = setFavorite,
                onClick = {
                    setFavorite = !setFavorite
                    onFavoriteClick(setFavorite)
                },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AnimeItemPreview() {
    AnimuTheme {
        AnimeDetailItem(
            id = 1,
            animeId = "",
            animeType = "",
            image = "",
            title = "Title",
            releaseDate = "2002",
            type = "TV",
            genre = "Gore",
            isFavorite = false,
            navigateToDetail = { _, _, _, _ -> },
            onFavoriteClick = {},
        )
    }
}