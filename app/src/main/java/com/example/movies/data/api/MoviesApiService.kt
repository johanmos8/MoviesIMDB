package com.example.movies.data.api

import com.example.movies.data.api.models.MovieResponse
import com.example.movies.data.utils.StringUtils.API_KEY
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface MoviesApiService {

    @GET("search/movie?api_key=${API_KEY}")
    suspend fun getMovies(@Query("query") query: String): MovieResponse

    @GET("movie/popular?api_key=${API_KEY}")
    suspend fun getPopularMovies(): MovieResponse

    @GET("movie/{id}?api_key=${API_KEY}")
    suspend fun getMovieDetailById(@Path("id") id: Int): MovieResponse.Movie
}
