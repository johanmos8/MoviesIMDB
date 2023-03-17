package com.example.movies.data.api.models

import com.squareup.moshi.Json

data class MovieResponse(
    val page: Int,
    val results: List<Movie>,
    @Json(name = "total_pages") val totalPages: Int,
    @Json(name = "total_results") val totalResults: Int,

    ) {
    data class Movie(
        val id: Int,
        val title: String?,
        val overview: String?,
        val popularity: Double,
        @Json(name = "poster_path") val posterPath: String? = "es nulo",
        @Json(name = "release_date") val releaseDate: String?,
        @Json(name = "vote_average") val voteAverage: Double,
        val video: Boolean
    )
}