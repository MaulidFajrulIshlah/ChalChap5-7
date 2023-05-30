package com.geminiboy.chalchap5.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClientTest {

    private lateinit var retrofit: Retrofit

    @Before
    fun setup() {
        val gson: Gson = GsonBuilder().create()
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
    }

    @Test
    fun testRetrofitClient() {
        assertNotNull(retrofit)
        assertNotNull(retrofit.baseUrl())
        assertNotNull(retrofit.converterFactories())
        assertNotNull(retrofit.callAdapterFactories())

        val client = retrofit.callFactory() as OkHttpClient
        assertNotNull(client)

        val interceptors: List<Interceptor> = client.interceptors
        assertNotNull(interceptors)

        val loggingInterceptor = interceptors.find { it is HttpLoggingInterceptor } as HttpLoggingInterceptor
        assertNotNull(loggingInterceptor)
        assertNotNull(loggingInterceptor.level)
        assertEquals(HttpLoggingInterceptor.Level.BODY, loggingInterceptor.level)

        val gsonConverterFactory =
            retrofit.converterFactories().find { it is GsonConverterFactory } as GsonConverterFactory
        assertNotNull(gsonConverterFactory)

        val restfulApi = retrofit.create(RestfulApi::class.java)
        assertNotNull(restfulApi)
    }
}

//

/*
1. testRetrofitClient(): Pengujian ini memeriksa konfigurasi RetrofitClient secara keseluruhan, termasuk properti utama seperti baseUrl, converterFactories, dan callAdapterFactories. Juga memastikan koneksi yang tepat antara RetrofitClient dan OkHttpClient, serta penggunaan GsonConverterFactory untuk konversi data. */
