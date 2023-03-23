package com.example.movies.presentation.di

import com.example.movies.domain.useCases.GetPopularMoviesUseCase
import com.example.movies.presentation.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val presentationModule = module {

    viewModel{ HomeViewModel(get(),get()) }

}
