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
    val uiState: Flow<Resource<Anime>> get() = _uiState

    fun recentReleaseAnimeDetail(id: Long, detailId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState = animeUseCase.getDetailRecentReleaseAnime(id, detailId)
        }
    }

    fun popularAnimeDetail(id: Long, detailId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState = animeUseCase.getDetailPopularAnime(id, detailId)
        }
    }

    fun topAirAnimeDetail(id: Long, detailId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState = animeUseCase.getDetailTopAiringAnime(id, detailId)
        }
    }
}