package com.andikas.animu.di

import com.andikas.animu.core.domain.usecase.AnimeInteractor
import com.andikas.animu.core.domain.usecase.AnimeUseCase
import com.andikas.animu.ui.screen.detail.DetailViewModel
import com.andikas.animu.ui.screen.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<AnimeUseCase> { AnimeInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}