package com.andikas.animu.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.andikas.animu.R
import com.andikas.animu.ui.theme.AnimuTheme
import com.andikas.animu.ui.theme.Poppins

@Composable
fun FavoriteButton(
    isFavorite: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    if (isFavorite) Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.color_favorite),
            contentColor = Color.White,
        ),
        onClick = onClick,
        modifier = modifier,
    ) {
        Icon(
            imageVector = Icons.Filled.Favorite,
            tint = Color.White,
            contentDescription = "Favorite",
            modifier = Modifier,
        )
        Text(
            text = "Add To Favorite",
            fontFamily = Poppins,
            color = Color.White,
            modifier = Modifier
                .padding(start = 8.dp),
        )
    }
    else OutlinedButton(
        border = BorderStroke(
            width = 1.dp,
            color = colorResource(id = R.color.color_favorite),
        ),
        onClick = onClick,
        modifier = modifier,
    ) {
        Icon(
            imageVector = Icons.Outlined.FavoriteBorder,
            tint = colorResource(id = R.color.color_favorite),
            contentDescription = "Favorite",
            modifier = Modifier,
        )
        Text(
            text = "Add To Favorite",
            fontFamily = Poppins,
            color = colorResource(id = R.color.color_favorite),
            modifier = Modifier
                .padding(start = 8.dp),
        )
    }
}

@Composable
fun ShortFavoriteButton(
    isFavorite: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    if (isFavorite) Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.color_favorite),
            contentColor = Color.White,
        ),
        onClick = onClick,
        modifier = modifier,
    ) {
        Icon(
            imageVector = Icons.Filled.Favorite,
            tint = Color.White,
            contentDescription = "Favorite",
            modifier = Modifier,
        )
    }
    else OutlinedButton(
        border = BorderStroke(
            width = 1.dp,
            color = colorResource(id = R.color.color_favorite),
        ),
        onClick = onClick,
        modifier = modifier,
    ) {
        Icon(
            imageVector = Icons.Outlined.FavoriteBorder,
            tint = colorResource(id = R.color.color_favorite),
            contentDescription = "Favorite",
            modifier = Modifier,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FavoriteButtonPreview() {
    AnimuTheme {
        ShortFavoriteButton(isFavorite = true, onClick = { })
    }
}