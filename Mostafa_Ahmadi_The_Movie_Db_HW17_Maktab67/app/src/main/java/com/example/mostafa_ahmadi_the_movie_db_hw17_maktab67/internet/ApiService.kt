package com.example.mostafa_ahmadi_the_movie_db_hw17_maktab67.internet

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
  suspend  fun getMovie(@Query("api_key") api_key:String): MoviesResponse
}