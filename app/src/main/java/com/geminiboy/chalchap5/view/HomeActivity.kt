package com.geminiboy.chalchap5.view

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.geminiboy.chalchap5.adapter.MovieAdapter
import com.geminiboy.chalchap5.databinding.ActivityHomeBinding
import com.geminiboy.chalchap5.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var movieAdapter: MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getData()
        sharedPreferences = getSharedPreferences("InsertAcc", MODE_PRIVATE)
        val getUss = sharedPreferences.getString("uss", "")
        binding.welcome.text ="Welcome, $getUss"
        binding.imageView.setOnClickListener {
            val giveUser = sharedPreferences.edit()
            giveUser.putString("uss", getUss)
            giveUser.apply()
            intent = Intent(this, ProfilActivity::class.java)
            startActivity(intent)
        }
        binding.imageView2.setOnClickListener {
            val intent = Intent(this, FavoriteActivity::class.java)
            startActivity(intent)
        }
    }

    fun getData(){
        movieAdapter = MovieAdapter(emptyList()){movie ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("id", movie.id)
            startActivity(intent)
        }
        val getVM = ViewModelProvider(this).get(MovieViewModel::class.java)
        getVM.getMovie()
        binding.rcvcon.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rcvcon.adapter = movieAdapter
        getVM.liveDataMovie.observe(this) { movie ->
            movieAdapter.listMovie = movie
            movieAdapter.notifyDataSetChanged()
        }

    }
}