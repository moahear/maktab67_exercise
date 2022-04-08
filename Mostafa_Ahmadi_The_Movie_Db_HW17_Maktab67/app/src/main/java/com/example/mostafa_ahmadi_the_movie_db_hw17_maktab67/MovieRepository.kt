package com.example.mostafa_ahmadi_the_movie_db_hw17_maktab67

import com.example.mostafa_ahmadi_the_movie_db_hw17_maktab67.internet.ApiClient
import com.example.mostafa_ahmadi_the_movie_db_hw17_maktab67.internet.MoviesResponse
import com.example.mostafa_ahmadi_the_movie_db_hw17_maktab67.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MovieRepository {
    fun getMovie() = flow{
        emit(ApiClient.apiService.getMovie(Constants.API_KEY))
    }.flowOn(Dispatchers.IO)


}