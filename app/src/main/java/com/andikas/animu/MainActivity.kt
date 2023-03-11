package com.andikas.animu

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.andikas.animu.ui.Animu
import com.andikas.animu.ui.theme.AnimuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimuTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Animu(
                        navigateToFavorite = {
                            startActivity(
                                Intent(
                                    this,
                                    Class.forName("com.andikas.animu.favorite.FavoriteActivity")
                                )
                            )
                        }
                    )
                }
            }
        }
    }
}