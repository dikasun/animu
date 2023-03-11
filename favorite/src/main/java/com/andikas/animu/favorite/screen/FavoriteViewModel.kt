package com.andikas.animu.favorite.screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andikas.animu.core.domain.model.Anime
import com.andikas.animu.core.domain.usecase.AnimeUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoriteViewModel(private val animeUseCase: AnimeUseCase) : ViewModel() {

    val favoriteRecentReleaseAnimeState = mutableStateOf<List<Anime>>(listOf())
    val favoritePopularAnimeState = mutableStateOf<List<Anime>>(listOf())
    val favoriteTopAirAnimeState = mutableStateOf<List<Anime>>(listOf())

    val favoriteRecentReleaseAnime = animeUseCase.getFavoriteRecentReleaseAnime()
    val favoritePopularAnime = animeUseCase.getFavoritePopularAnime()
    val favoriteTopAirAnime = animeUseCase.getFavoriteTopAiringAnime()

    fun setFavoriteRecentReleaseAnime(anime: Anime, state: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            animeUseCase.setFavoriteRecentReleaseAnime(anime, state)
        }
    }

    fun setFavoritePopularAnime(anime: Anime, state: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            animeUseCase.setFavoritePopularAnime(anime, state)
        }
    }

    fun setFavoriteTopAiringAnime(anime: Anime, state: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            animeUseCase.setFavoriteTopAiringAnime(anime, state)
        }
    }
}