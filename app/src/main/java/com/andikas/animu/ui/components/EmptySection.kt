package com.andikas.animu.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andikas.animu.R
import com.andikas.animu.ui.theme.Poppins

@Composable
fun EmptySection(
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(30.dp)
            .fillMaxWidth(),
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_empty_folder),
            contentDescription = null,
            modifier = Modifier
                .size(128.dp),
        )
        Text(
            text = "Oops looks like you haven't any favorite anime",
            fontSize = 18.sp,
            color = Color.White,
            fontFamily = Poppins,
            modifier = Modifier
                .padding(top = 16.dp),
        )
    }
}