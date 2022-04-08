package com.example.mostafa_ahmadi_the_movie_db_hw17_maktab67

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.mostafa_ahmadi_the_movie_db_hw17_maktab67.databinding.FragmentShowMovieBinding
import com.example.mostafa_ahmadi_the_movie_db_hw17_maktab67.internet.MoviesViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber


class ShowMovieFragment : Fragment() {

    private val binding by lazy{
        FragmentShowMovieBinding.inflate(layoutInflater)
    }
    private val movieAdapter by lazy { MovieAdapter() }
    private val moviesViewModel:MoviesViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

       binding.apply {
           rvMovie.adapter=movieAdapter
           moviesViewModel.getMovieForView()
          lifecycleScope.launch{
              moviesViewModel.stateMovie.collect {
               movieAdapter.submitList(it)

              }
          }
       }
        return binding.root




    }


}

