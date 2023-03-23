package com.example.movies.domain.useCases

import com.example.movies.domain.models.Movie
import com.example.movies.domain.repositories.MovieRepository

class GetPopularMoviesUseCase(
    private val movieRepository: MovieRepository
) : BaseUseCase<Unit, List<Movie>> {
    override suspend fun execute(params: Unit): List<Movie> = movieRepository.getPopularMovies()
}