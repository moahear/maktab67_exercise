package com.example.mostafa_ahmadi_the_movie_db_hw17_maktab67

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mostafa_ahmadi_the_movie_db_hw17_maktab67.databinding.ItemMovieRvBinding
import com.example.mostafa_ahmadi_the_movie_db_hw17_maktab67.internet.Movie
import com.example.mostafa_ahmadi_the_movie_db_hw17_maktab67.utils.bindImage

class MovieAdapter:ListAdapter<Movie,MovieAdapter.MovieViewHolder>(DiffCallback) {

    companion object DiffCallback: DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return  oldItem===newItem
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
           return oldItem.id==newItem.id
        }
    }


    class MovieViewHolder(private val binding:ItemMovieRvBinding):RecyclerView.ViewHolder(binding.root) {

        fun bindMovie(movie: Movie) {
            binding.movie=movie

            Glide.with(binding.root).load("https://image.tmdb.org/t/p/w342${movie.posterPath}")
                .apply(
                    RequestOptions().placeholder(R.drawable.loading_img)
                        .error(R.drawable.ic_baseline_broken_image_24)
                        .centerCrop()
                ).into(binding.imgPoster)

            binding.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
       return MovieViewHolder(ItemMovieRvBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(getItem(position))


    }
}
