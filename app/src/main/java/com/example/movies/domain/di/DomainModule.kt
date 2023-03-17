package com.example.movies.domain.di

import com.example.movies.domain.useCases.MovieUseCase
import org.koin.dsl.module


val domainModule = module {

    factory { MovieUseCase(get()) }

}
