package com.example.mostafa_ahmadi_the_movie_db_hw17_maktab67

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mostafa_ahmadi_the_movie_db_hw17_maktab67.databinding.FragmentMoviePlayerBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem


class MoviePlayerFragment : Fragment() {


    private val binding by lazy{
        FragmentMoviePlayerBinding.inflate(layoutInflater)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        //create instance===========================
       val player= ExoPlayer.Builder(container!!.context).build()
        binding.apply {

            videoView.player=player
            player.setMediaItem(MediaItem.fromUri("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4"))
            player.prepare()
            player.play()
        }



        //===================================
        return binding.root
    }


    fun player() {
        context?.let { ExoPlayer.Builder(it).build() }

    }
}