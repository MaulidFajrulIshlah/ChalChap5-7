package com.geminiboy.chalchap5.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geminiboy.chalchap5.model.MovieApi
import com.geminiboy.chalchap5.model.Result
import com.geminiboy.chalchap5.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel : ViewModel(){
    lateinit var liveDataMovie:MutableLiveData<List<com.geminiboy.chalchap5.model.Result>>
    lateinit var liveDetail: MutableLiveData<com.geminiboy.chalchap5.model.Result>
    init {
        liveDataMovie = MutableLiveData()
        liveDetail = MutableLiveData()
    }
    fun getMovie() {
        RetrofitClient.instance.getPopularMovies(
            apiKey = "e73ba4baa44323fa06e5497760f26ab5",
            page = 1
        ).enqueue(object : Callback<MovieApi<com.geminiboy.chalchap5.model.Result>> {
            override fun onResponse(call: Call<MovieApi<com.geminiboy.chalchap5.model.Result>>, response: Response<MovieApi<com.geminiboy.chalchap5.model.Result>>) {
                if (response.isSuccessful){
                    val movieresponse = response.body()
                    liveDataMovie.postValue(movieresponse?.results)

                }else{
                    liveDataMovie.value = emptyList()
                }
            }

            override fun onFailure(call: Call<MovieApi<com.geminiboy.chalchap5.model.Result>>, t: Throwable) {
                liveDataMovie.value = emptyList()
            }

        })


    }
    fun getMovieDetail(movieId:Int) {
        RetrofitClient.instance.getMovieDetails(movieId, "5e61354ae870271823c8ccac3c5c2403")
            .enqueue(object : Callback<com.geminiboy.chalchap5.model.Result> {
                override fun onResponse(call: Call<com.geminiboy.chalchap5.model.Result>, response: Response<com.geminiboy.chalchap5.model.Result>) {
                    if (response.isSuccessful) {
                        val movie = response.body()
                        liveDetail.value = movie
                    }
                }

                override fun onFailure(call: Call<com.geminiboy.chalchap5.model.Result>, t: Throwable) {
                    liveDataMovie.value = emptyList()
                }

            })
    }



}

