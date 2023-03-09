package com.andikas.animu.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.andikas.animu.R.string

@Composable
fun ErrorSection(
    modifier: Modifier = Modifier,
    message: String,
) {
    Column(
        modifier = modifier
            .padding(64.dp)
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            modifier = Modifier
                .size(64.dp),
            imageVector = Icons.Default.Warning,
            colorFilter = ColorFilter.tint(Color(0xFFFF2929)),
            contentDescription = stringResource(id = string.warning)
        )
        Text(
            text = message,
            color = Color(0xFFFF2929),
            textAlign = TextAlign.Center,
        )
    }
}