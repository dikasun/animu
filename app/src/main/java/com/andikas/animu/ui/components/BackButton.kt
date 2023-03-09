package com.andikas.animu.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIos
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.andikas.animu.R
import com.andikas.animu.ui.theme.AnimuTheme

@Composable
fun BackButton(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    IconButton(
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = colorResource(id = R.color.color_primary),
            contentColor = Color.White,
        ),
        onClick = navigateBack,
        modifier = modifier
            .size(48.dp)
            .clip(CircleShape),
    ) {
        Icon(
            imageVector = Icons.Rounded.ArrowBackIos,
            tint = Color.White,
            contentDescription = "Back",
        )
    }
}

@Preview
@Composable
fun BackButtonPreview() {
    AnimuTheme {
        BackButton(
            navigateBack = { },
        )
    }
}