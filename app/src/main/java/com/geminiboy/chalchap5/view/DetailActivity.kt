package com.geminiboy.chalchap5.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.geminiboy.chalchap5.databinding.ActivityDetailBinding
import com.geminiboy.chalchap5.viewmodel.MovieViewModel

@Suppress("DEPRECATION")
class DetailActivity : AppCompatActivity() {
    lateinit var viewModel: MovieViewModel
    lateinit var binding: ActivityDetailBinding
    override  fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var getDetail = intent.getIntExtra("id", -1)
        viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        viewModel.liveDetail.observe(this){movie ->
            bindMovieData(movie)
        }
        viewModel.getMovieDetail(getDetail)
    }
    private fun bindMovieData(movie: com.geminiboy.chalchap5.model.Result) {
        if (movie != null) {
            binding.apply {
                Glide.with(this@DetailActivity)
                    .load("https://image.tmdb.org/t/p/w500${movie.posterPath}")
                    .into(imageView2)
                judul.text = movie.title
                Tanggal.text = movie.releaseDate
                Deskripsi.text = movie.overview
            }
        }
    }
}