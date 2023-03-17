package com.example.movies.presentation.ui.home.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import com.example.movies.databinding.FragmentSearchBinding
import com.example.movies.domain.models.Movie
import com.example.movies.presentation.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel: HomeViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //TODO("Meter en funcion")
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                return true
            }

            override fun onQueryTextChange(query: String?): Boolean {
                if (!query.isNullOrEmpty()) {
                    sharedViewModel.getMoviesBySearch(query)
                }
                return true
            }

        })
        sharedViewModel.movies.observe(viewLifecycleOwner) { movies ->
            loadRecyclerView(movies)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun loadFoundMovies(): LiveData<List<Movie>> {
        return sharedViewModel.movies

    }

    fun loadRecyclerView(movies: List<Movie>) {
        binding.lifecycleOwner = this
        binding.viewModel = sharedViewModel
        binding.foundMoviesList.adapter = MovieAdapter(movies)
    }
}