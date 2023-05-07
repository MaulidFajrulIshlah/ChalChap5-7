package com.geminiboy.chalchap5.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geminiboy.chalchap5.network.RetrofitClient
import com.geminiboy.chalchap5.model.Result
import com.geminiboy.chalchap5.model.MovieApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel : ViewModel(){
    var liveDataMovie: MutableLiveData<List<Result>>
    var liveDetail: MutableLiveData<com.geminiboy.chalchap5.model.Result>
    init {
        liveDataMovie = MutableLiveData()
        liveDetail = MutableLiveData()
    }
    fun getMovie() {
        RetrofitClient.instance.getPopularMovies(
            apiKey = "5e61354ae870271823c8ccac3c5c2403",
            page = 1
        ).enqueue(object : Callback<MovieApi<Result>> {
            override fun onResponse(call: Call<MovieApi<Result>>, response: Response<MovieApi<Result>>) {
                if (response.isSuccessful){
                    val movieresponse = response.body()
                    liveDataMovie.postValue(movieresponse?.results)
                }else{
                    liveDataMovie.value = emptyList()
                }
            }
            override fun onFailure(call: Call<MovieApi<Result>>, t: Throwable) {
                liveDataMovie.value = emptyList()
            }
        })
    }
    fun getMovieDetail(movieId:Int) {
        RetrofitClient.instance.getMovieDetails(movieId, "5e61354ae870271823c8ccac3c5c2403")
            .enqueue(object : Callback<com.geminiboy.chalchap5.model.Result> {
                override fun onResponse(call: Call<Result>, response: Response<Result>) {
                    if (response.isSuccessful) {
                        val movie = response.body()
                        liveDetail.value = movie
                    }
                }

                override fun onFailure(call: Call<Result>, t: Throwable) {
                    liveDataMovie.value = emptyList()
                }

            })
    }



}