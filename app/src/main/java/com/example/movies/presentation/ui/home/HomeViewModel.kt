package com.example.movies.presentation.ui.home

import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.domain.models.Movie
import com.example.movies.domain.useCases.MovieUseCase
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch

class HomeViewModel(
    private val movieUseCase: MovieUseCase
) : ViewModel() {
    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<String>()

    // The external immutable LiveData for the request status
    val status: LiveData<String> = _status

    //Definition of Livedata for movies by query.
    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> = _movies

    //Definition of Livedata for list of popular movies.
    private val _popularMovies = MutableLiveData<List<Movie>>()
    val popularMovies: LiveData<List<Movie>> = _popularMovies

    //Definition of Livedata for a single movie.
    private val _movie = MutableLiveData<Movie>()
    val movie: LiveData<Movie> = _movie

    //TODO("revisar buenas practicas")
    //Definition of movieselected when the user clicks the list.
    lateinit var _movieSelected: Movie
    val movieSelected get() = _movieSelected!!

    // Create a MutableLiveData to hold the search query
    var _searchQuery = MutableLiveData<String>()
    val searchQuery: LiveData<String> = _searchQuery

    /**
     * Get a list of movies using  a query word.
     */
    fun getMoviesBySearch(query: String) {
        viewModelScope.launch {

            if (!query.isNullOrEmpty()) {
                _movies.value = movieUseCase.getMoviesBySearch(query)
            }


        }
    }

    /**
     * Get a list of popular movies
     */
    fun getPopularMovies() {
        viewModelScope.launch {
            _popularMovies.value = movieUseCase.getPopularMovies()
        }
    }

    /**
     * Get a list of popular movies
     */
    fun getMovieById(id: Int) {
        viewModelScope.launch {
            _movie.value = movieUseCase.getMovieById(id)
        }
    }
}