package com.geminiboy.chalchap5.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geminiboy.chalchap5.databinding.ActivityFavoriteBinding
import dagger.hilt.android.AndroidEntryPoint
import com.geminiboy.chalchap5.adapter.FavoriteAdapter
import com.geminiboy.chalchap5.adapter.MovieAdapter

@AndroidEntryPoint
class FavoriteActivity : AppCompatActivity() {

    private lateinit var movieAdapter: MovieAdapter
    private lateinit var binding : ActivityFavoriteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}