package com.example.movies.presentation.ui.home.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.movies.databinding.FragmentHomeBinding
import com.example.movies.domain.models.Movie
import com.example.movies.presentation.ui.home.HomeViewModel
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        Log.d("checkingBottom", "home")
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("checkingBottom", "home onviewcreated")

        // Enable JavaScript in the WebView
        binding.youtubeWebview.settings.javaScriptEnabled = true

        // Load the YouTube video using the YouTube IFrame Player API
        binding.youtubeWebview.loadData(
            "<html><body>" + "<iframe class=\"youtube-player\" type=\"text/html\" width=\"100%\" height=\"wrap_content\" src=\"https://www.youtube.com/embed/_Z3QKkl1WyM\" frameborder=\"0\" allowfullscreen></iframe>" + "</body></html>",
            "text/html",
            "utf-8"
        )
        sharedViewModel.getPopularMovies()
        //TODO("hacerlo dinamico")
        sharedViewModel.getMovieById(505642)
        sharedViewModel.popularMovies.observe(viewLifecycleOwner) { movies ->
            loadPopularMovies(movies)
        }
        sharedViewModel.movie.observe(viewLifecycleOwner) { movie ->
            Picasso.get().load("https://image.tmdb.org/t/p/original${movie.posterPath}")
                .into(binding.movieImage)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun loadPopularMovies(movies: List<Movie>) {
        binding.lifecycleOwner = this
        binding.viewModel = sharedViewModel
        binding.popularMoviesList.adapter =
            PopularMoviesAdapter(sharedViewModel.popularMovies.value!!)
    }

}