package com.geminiboy.chalchap5.network

import com.geminiboy.chalchap5.model.MovieApi
import com.geminiboy.chalchap5.model.Result
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface RestfulApi {
    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): Call<MovieApi<com.geminiboy.chalchap5.model.Result>>
    @GET("movie/{id}")
    fun getMovieDetails(
        @Path("id") movieId: Int,
        @Query("api_key") apiKey: String
    ): Call<com.geminiboy.chalchap5.model.Result>
}