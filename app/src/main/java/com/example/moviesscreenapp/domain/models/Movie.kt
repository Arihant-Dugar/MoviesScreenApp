package com.example.moviesscreenapp.domain.models

import androidx.annotation.DrawableRes

data class Movie(
    val title : String,
    @DrawableRes val similarMovie : Int
)
