package com.example.movies.presentation.ui.home.play

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.movies.databinding.FragmentPlayBinding
import com.example.movies.presentation.ui.home.HomeViewModel
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlayFragment : Fragment() {

    private var _binding: FragmentPlayBinding? = null
    private val binding get() = _binding!!
    private val sharedViewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPlayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setUpView() {
        binding.apply {
            lifecycleOwner=viewLifecycleOwner
            movie=sharedViewModel.movieSelected
        }

        Picasso.get().load("https://image.tmdb.org/t/p/original${sharedViewModel.movieSelected.posterPath}")
            .into(binding.movieImage)

    }

}