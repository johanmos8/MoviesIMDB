package com.example.movies.presentation.ui.home.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.databinding.ItemListBinding
import com.example.movies.domain.models.Movie
import com.squareup.picasso.Picasso

class MovieAdapter(
    private val dataset: List<Movie>
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var listener: Listener? = null
    inner class MovieViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {



        fun bind(movie: Movie) {
            binding.movie = movie
            binding.executePendingBindings()
            // Image
            //ToDo("Organizar bien el path")
            Picasso.get()
                .load("https://image.tmdb.org/t/p/original${movie.posterPath}")
                .into(binding.movieImage)
            // SetUp Listener
            binding.parentMovieList.setOnClickListener {
                listener?.itemClicked(movie)
            }
        }
    }
    interface Listener {
        fun itemClicked(movie: Movie)
    }
    fun addListener(newListener: Listener) {
        this.listener = newListener
    }
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just an Affirmation object.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        //create a new view
        val adapterLayout = LayoutInflater.from(parent.context)

        val binding = ItemListBinding.inflate(adapterLayout, parent, false)
        return MovieViewHolder(binding)
    }

    /**
     * Return the size of your dataset (invoked by the layout manager)
     */
    override fun getItemCount() = dataset.size


    /**
     * Replace the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        val item = dataset[position]
        holder.bind(item)

    }

}