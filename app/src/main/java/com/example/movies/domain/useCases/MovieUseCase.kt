package com.example.movies.domain.useCases

import com.example.movies.domain.models.Movie
import com.example.movies.domain.repositories.MovieRepository

class MovieUseCase(
    private val movieRepository: MovieRepository
) {
    /**
     * Function that ask for movies taking into account a word or phrase
     * @param [query] word or phrase to be searched
     * @return [List<Movie>]
     */
    suspend fun getMoviesBySearch(query: String): List<Movie> {
        return movieRepository.getMoviesBySearch(query)
    }

    /**
     * Return the most popular list of movies
     */
    suspend fun getPopularMovies(): List<Movie> {
        return movieRepository.getPopularMovies()
    }

    /**
     * get the detail of movie using its id
     * @param [id:Int] movie id
     * @return [Movie]
     */
    suspend fun getMovieById(id: Int): Movie {
        return movieRepository.getMovieById(id)
    }
}