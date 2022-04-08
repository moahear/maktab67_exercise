package com.example.mostafa_ahmadi_the_movie_db_hw17_maktab67

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.mostafa_ahmadi_the_movie_db_hw17_maktab67.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.apply {
            toolbar.title=""
            setSupportActionBar(toolbar)
            ActionBarDrawerToggle(this@MainActivity,drawerLayout,toolbar,0,0).syncState()

        }




    }
}