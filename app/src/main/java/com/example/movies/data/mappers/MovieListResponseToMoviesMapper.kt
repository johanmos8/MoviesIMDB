package com.example.movies.data.mappers

import com.example.movies.data.api.models.MovieResponse
import com.example.movies.domain.models.Movie


class MovieListResponseToMoviesMapper {

    operator fun invoke(listMovies: List<MovieResponse.Movie>): List<Movie> {
        with(listMovies) {
            //TODO("Encadenar mappers")
            return listMovies.map { movieResponse ->
                Movie(
                    id = movieResponse.id,
                    title = movieResponse.title,
                    overview = movieResponse.overview,
                    popularity = movieResponse.popularity,
                    posterPath = movieResponse.posterPath,
                    releaseDate = movieResponse.releaseDate,
                    video = movieResponse.video,
                    voteAverage = movieResponse.voteAverage
                )
            }
        }

    }
}