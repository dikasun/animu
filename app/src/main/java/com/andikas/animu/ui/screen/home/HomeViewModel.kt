package com.andikas.animu.ui.screen.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.andikas.animu.core.domain.model.Anime
import com.andikas.animu.core.domain.usecase.AnimeUseCase

class HomeViewModel(animeUseCase: AnimeUseCase) : ViewModel() {

    val recentReleaseAnimeState = mutableStateOf<List<Anime>>(listOf())
    val popularAnimeState = mutableStateOf<List<Anime>>(listOf())
    val topAirAnimeState = mutableStateOf<List<Anime>>(listOf())

    val recentReleaseAnime = animeUseCase.getRecentReleaseAnime()
    val popularAnime = animeUseCase.getPopularAnime()
    val topAirAnime = animeUseCase.getTopAiringAnime()
}