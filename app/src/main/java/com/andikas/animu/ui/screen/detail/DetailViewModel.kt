package com.andikas.animu.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andikas.animu.core.data.Resource
import com.andikas.animu.core.domain.model.Anime
import com.andikas.animu.core.domain.usecase.AnimeUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch

class DetailViewModel(private val animeUseCase: AnimeUseCase) : ViewModel() {

    private var _uiState: Flow<Resource<Anime>> = flowOf(Resource.Loading())
    val uiState get() = _uiState

    fun recentReleaseAnimeDetail(id: Long, detailId: String, favorite: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState = animeUseCase.getDetailRecentReleaseAnime(id, detailId, favorite)
        }
    }

    fun popularAnimeDetail(id: Long, detailId: String, favorite: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState = animeUseCase.getDetailPopularAnime(id, detailId, favorite)
        }
    }

    fun topAirAnimeDetail(id: Long, detailId: String, favorite: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState = animeUseCase.getDetailTopAiringAnime(id, detailId, favorite)
        }
    }

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