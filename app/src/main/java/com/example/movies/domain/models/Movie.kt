package com.example.movies.domain.models


data class Movie(
    val id: Int,
    val title: String?,
    val overview: String?,
    val popularity: Double,
    val posterPath: String? = "",
    val releaseDate: String?,
    val video: Boolean,
    val voteAverage: Double
)