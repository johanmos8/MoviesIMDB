package com.example.movies.data.mappers

import com.example.movies.data.api.models.MovieResponse
import com.example.movies.domain.models.Movie

class MovieResponseToMovieMapper {
    operator fun invoke(movie: MovieResponse.Movie): Movie {
        with(movie) {
            return Movie(
                id = movie.id,
                title = movie.title,
                overview = movie.overview,
                popularity = movie.popularity,
                posterPath = movie.posterPath,
                releaseDate = movie.releaseDate,
                video = movie.video,
                voteAverage = movie.voteAverage
            )
        }
    }

}
