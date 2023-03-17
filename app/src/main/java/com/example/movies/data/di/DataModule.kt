package com.example.movies.data.di

import com.example.movies.data.api.RetroFitClient
import com.example.movies.data.mappers.MovieListResponseToMoviesMapper
import com.example.movies.data.mappers.MovieResponseToMovieMapper
import com.example.movies.data.repositories.MovieRepositoryImpl
import com.example.movies.domain.repositories.MovieRepository
import org.koin.dsl.module


val dataModule = module {

    factory<MovieRepository> { MovieRepositoryImpl(get(), get(),get()) }
    factory { MovieListResponseToMoviesMapper() }
    factory { MovieResponseToMovieMapper() }
    single { RetroFitClient }
}
