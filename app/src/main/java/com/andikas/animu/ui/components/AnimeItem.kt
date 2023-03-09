package com.andikas.animu.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.andikas.animu.ui.common.AnimeType
import com.andikas.animu.ui.theme.AnimuTheme
import com.andikas.animu.ui.theme.Poppins

@Composable
fun AnimeItem(
    id: Long,
    animeId: String,
    type: String,
    image: String,
    navigateToDetail: (
        animeId: String,
        id: Long,
        type: String,
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
            .clickable { navigateToDetail(animeId, id, type) },
    )
}

@Composable
fun AnimeBannerItem(
    id: Long,
    animeId: String,
    type: String,
    image: String,
    navigateToDetail: (
        animeId: String,
        id: Long,
        type: String,
    ) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
    ) {
        SubcomposeAsyncImage(
            model = image,
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
                .width(640.dp)
                .clickable { navigateToDetail(animeId, id, type) },
        )
        FavoriteButton(
            isFavorite = false,
            onClick = { },
            modifier = Modifier
                .padding(20.dp)
                .align(Alignment.BottomStart),
        )
    }
}

@Composable
fun AnimeDetailItem(
    id: Long,
    animeId: String,
    image: String,
    title: String,
    releaseDate: String,
    type: String,
    genre: String,
    navigateToDetail: (
        animeId: String,
        id: Long,
    ) -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .height(210.dp)
            .fillMaxWidth()
            .clickable { navigateToDetail(animeId, id) }
    ) {
        Row {
            SubcomposeAsyncImage(
                model = image,
                loading = {
                    LoadingSection()
                },
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxHeight()
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
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        fontWeight = FontWeight.SemiBold,
                    )
                    Text(
                        text = "$releaseDate | $type",
                        fontSize = 18.sp,
                        fontFamily = Poppins,
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
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .padding(top = 8.dp),
                    )
                }
                FavoriteButton(
                    isFavorite = false,
                    onClick = { },
                )
            }
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
            image = "",
            title = "Title",
            releaseDate = "2002",
            type = "TV",
            genre = "Gore",
            navigateToDetail = { _, _ -> },
        )
    }
}