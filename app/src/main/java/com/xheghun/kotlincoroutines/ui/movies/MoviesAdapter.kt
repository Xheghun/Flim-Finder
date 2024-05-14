package com.xheghun.kotlincoroutines.ui.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.xheghun.kotlincoroutines.R
import com.xheghun.kotlincoroutines.credentials.MOVIE_IMAGE_BASE_PATH
import com.xheghun.kotlincoroutines.data.model.Movie
import com.xheghun.kotlincoroutines.databinding.ItemMovieBinding
import com.xheghun.kotlincoroutines.di.MoviesGlideModule

/**
 * Inflates and displays the [Movie] data in a list.
 * */
class MovieAdapter : RecyclerView.Adapter<MovieViewHolder>() {

    private val items = mutableListOf<Movie>()

    fun setData(newItems: List<Movie>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.showData(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(view)
    }
}

class MovieViewHolder(private val binding: ItemMovieBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun showData(movie: Movie) = with(itemView) {
        Glide.with(this)
            .load(MOVIE_IMAGE_BASE_PATH + movie.posterPath)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(binding.movieImage)
    }
}