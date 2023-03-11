package com.andikas.animu.favorite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.andikas.animu.favorite.di.favoriteModule
import com.andikas.animu.favorite.screen.FavoriteScreen
import com.andikas.animu.ui.theme.AnimuTheme
import org.koin.core.context.loadKoinModules

class FavoriteActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(favoriteModule)

        setContent {
            AnimuTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FavoriteScreen(
                        navigateBack = { onBackPressedDispatcher.onBackPressed() }
                    )
                }
            }
        }
    }
}