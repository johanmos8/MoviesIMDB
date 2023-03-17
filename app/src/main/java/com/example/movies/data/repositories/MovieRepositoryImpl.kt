package com.example.movies.data.repositories

import android.util.Log
import com.example.movies.data.api.RetroFitClient
import com.example.movies.data.mappers.MovieListResponseToMoviesMapper
import com.example.movies.data.mappers.MovieResponseToMovieMapper
import com.example.movies.domain.models.Movie
import com.example.movies.domain.repositories.MovieRepository
import retrofit2.HttpException
import java.io.IOException

class MovieRepositoryImpl(
    private val movieListResponseToMoviesMapper: MovieListResponseToMoviesMapper,
    private val movieResponseToMovieMapper: MovieResponseToMovieMapper,
    private val retrofit: RetroFitClient
) : MovieRepository {

    /**
     * Implementation of the function to get movies by searching using a word
     */
    override suspend fun getMoviesBySearch(query: String): List<Movie> {

        return movieListResponseToMoviesMapper(retrofit.retrofitService.getMovies(query).results)

    }

    override suspend fun getPopularMovies(): List<Movie> {
        return movieListResponseToMoviesMapper(retrofit.retrofitService.getPopularMovies().results)
    }


    override suspend fun getMovieById(id: Int): Movie {

        return movieResponseToMovieMapper(retrofit.retrofitService.getMovieDetailById(id))
    }
}