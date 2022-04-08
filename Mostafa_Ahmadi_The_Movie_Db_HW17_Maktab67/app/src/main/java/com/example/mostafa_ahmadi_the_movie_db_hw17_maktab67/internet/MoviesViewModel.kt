package com.example.mostafa_ahmadi_the_movie_db_hw17_maktab67.internet

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mostafa_ahmadi_the_movie_db_hw17_maktab67.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

//کالکت صحیح
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MoviesViewModel:ViewModel() {

    private val moviesRepository=MovieRepository()
    private val _stateMovie= MutableStateFlow<List<Movie>>(emptyList())
    val stateMovie =_stateMovie
    //: StateFlow<List<Movie>>

   // get() = _stateMovie

    fun getMovieForView() {
        viewModelScope.launch {
            moviesRepository.getMovie().collect {
         _stateMovie.value=it.results!!
            }
        }

    }


}