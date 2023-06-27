package com.example.movies.domain.repositories

import com.example.movies.domain.models.Movie

interface MovieRepository {
    suspend fun getMoviesBySearch(query: String): List<Movie>
    suspend fun getPopularMovies(): List<Movie>
    suspend fun getMovieById(id: Int):Movie
}