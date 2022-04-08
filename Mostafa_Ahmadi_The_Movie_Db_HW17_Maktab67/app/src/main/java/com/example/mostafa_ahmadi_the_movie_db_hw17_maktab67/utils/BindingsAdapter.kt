package com.example.mostafa_ahmadi_the_movie_db_hw17_maktab67.utils

import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mostafa_ahmadi_the_movie_db_hw17_maktab67.R
import com.google.android.material.imageview.ShapeableImageView

@BindingAdapter("img_item_movie")
fun ShapeableImageView.bindImage(imageUrl: String?) {

    imageUrl?.let {

        Glide.with(this.context).load(imageUrl.toUri().buildUpon().scheme("https").build())
            .apply(
                RequestOptions().placeholder(R.drawable.loading_img)
                    .error(R.drawable.ic_baseline_broken_image_24)
            ).into(this)
    }
}