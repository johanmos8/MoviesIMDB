package com.example.movies.domain.di

import com.example.movies.domain.useCases.GetPopularMoviesUseCase
import com.example.movies.domain.useCases.MovieUseCase
import org.koin.dsl.module


val domainModule = module {

    factory { MovieUseCase(get()) }
    factory { GetPopularMoviesUseCase(get()) }

}
