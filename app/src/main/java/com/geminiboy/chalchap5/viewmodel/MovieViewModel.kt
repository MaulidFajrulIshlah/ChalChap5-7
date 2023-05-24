package com.geminiboy.chalchap5.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geminiboy.chalchap5.model.MovieApi
import com.geminiboy.chalchap5.model.Result
import com.geminiboy.chalchap5.network.RestfulApi
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MovieViewModel  @Inject constructor(private var api : RestfulApi): ViewModel(){

    var liveDataMovie:MutableLiveData<List<Result>> = MutableLiveData()
    var liveDetail: MutableLiveData<Result> = MutableLiveData()
    fun getMovie() {
        api.getPopularMovies(
            apiKey = "e73ba4baa44323fa06e5497760f26ab5",
            page = 1
        ).enqueue(object : Callback<MovieApi> {
            override fun onResponse(call: Call<MovieApi>, response: Response<MovieApi>) {
                if (response.isSuccessful){
                    val movieresponse = response.body()
                    liveDataMovie.postValue(movieresponse?.results)

                }else{
                    liveDataMovie.value = emptyList()
                }
            }

            override fun onFailure(call: Call<MovieApi>, t: Throwable) {
                liveDataMovie.value = emptyList()
            }

        })


    }
    fun getMovieDetail(movieId:Int) {
        api.getMovieDetails(movieId, "5e61354ae870271823c8ccac3c5c2403")
            .enqueue(object : Callback<Result> {
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

