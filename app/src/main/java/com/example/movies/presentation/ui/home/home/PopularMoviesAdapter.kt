package com.example.movies.presentation.ui.home.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.databinding.ItemMoviePopularBinding
import com.example.movies.domain.models.Movie
import com.squareup.picasso.Picasso

class PopularMoviesAdapter(
    private val popularMovies: List<Movie>
) : RecyclerView.Adapter<PopularMoviesAdapter.MovieViewHolder>() {

    class MovieViewHolder(private val itemBinding: ItemMoviePopularBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(movie: Movie) {
            itemBinding.movie = movie

            // Image
            //ToDo("Organizar bien el path")
            Picasso.get()
                .load("https://image.tmdb.org/t/p/original${movie.posterPath}")
                .into(itemBinding.movieImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
        val binding = ItemMoviePopularBinding.inflate(adapterLayout, parent, false)

        return MovieViewHolder(binding)
    }

    override fun getItemCount() = popularMovies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = popularMovies[position]
        holder.bind(item)
    }
}