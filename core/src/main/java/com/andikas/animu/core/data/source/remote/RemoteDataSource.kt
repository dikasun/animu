package com.andikas.animu.core.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.andikas.animu.core.data.source.remote.network.ApiResponse
import com.andikas.animu.core.data.source.remote.network.ApiService
import com.andikas.animu.core.data.source.remote.response.AnimeDetailResponse
import com.andikas.animu.core.data.source.remote.response.ListAnimeResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource(private val apiService: ApiService) {

    suspend fun getRecentReleaseAnime(): Flow<ApiResponse<ListAnimeResponse>> {
        return flow {
            try {
                val response = apiService.getRecentReleaseAnime()
                if (response.isNotEmpty()) emit(ApiResponse.Success(response))
                else emit(ApiResponse.Empty)
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getPopularAnime(): Flow<ApiResponse<ListAnimeResponse>> {
        return flow {
            try {
                val response = apiService.getPopularAnime()
                if (response.isNotEmpty()) emit(ApiResponse.Success(response))
                else emit(ApiResponse.Empty)
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getTopAiringAnime(): Flow<ApiResponse<ListAnimeResponse>> {
        return flow {
            try {
                val response = apiService.getTopAiringAnime()
                if (response.isNotEmpty()) emit(ApiResponse.Success(response))
                else emit(ApiResponse.Empty)
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getDetailAnime(anime: String): Flow<ApiResponse<AnimeDetailResponse>> {
        return flow {
            try {
                val response = apiService.getDetailAnime(anime)
                emit(ApiResponse.Success(response))
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}