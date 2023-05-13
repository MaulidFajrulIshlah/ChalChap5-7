package com.geminiboy.chalchap5.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geminiboy.chalchap5.databinding.ItemMovieBinding
import com.bumptech.glide.Glide
import com.geminiboy.chalchap5.model.MovieApi
import com.geminiboy.chalchap5.model.Result

class MovieAdapter(var listMovie : List<com.geminiboy.chalchap5.model.Result>,
                   var onItemClick: ((com.geminiboy.chalchap5.model.Result) -> Unit) ) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    class ViewHolder (var binding: ItemMovieBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.ViewHolder {
        val view = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieAdapter.ViewHolder, position: Int) {
        holder.binding.Judul.text = listMovie[position].originalTitle
        holder.binding.Rating.text = listMovie[position].voteAverage.toString()
        holder.binding.Tanggal.text = listMovie[position].releaseDate
        Glide.with(holder.itemView).load("https://image.tmdb.org/t/p/w500${listMovie[position].posterPath}").into(holder.binding.Poster)
        holder.binding.card.setOnClickListener{
            onItemClick(listMovie[position])
        }

    }

    override fun getItemCount(): Int {
        return listMovie.size
    }

}


