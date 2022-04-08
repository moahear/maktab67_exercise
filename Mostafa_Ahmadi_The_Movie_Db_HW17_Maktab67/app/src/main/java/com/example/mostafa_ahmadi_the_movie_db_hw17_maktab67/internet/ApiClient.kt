package com.example.mostafa_ahmadi_the_movie_db_hw17_maktab67.internet

import com.example.mostafa_ahmadi_the_movie_db_hw17_maktab67.utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {

    val apiService by lazy {

        Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder()
                .connectTimeout(1L,TimeUnit.MINUTES)
                .writeTimeout(1L,TimeUnit.MINUTES)
                .writeTimeout(1L,TimeUnit.MINUTES).build())
            .build().create(ApiService::class.java)
    }
}