package com.example.moviesscreenapp.domain.models

import androidx.annotation.DrawableRes

data class CastMembers(
    val name : String,
    @DrawableRes val castImg : Int
)
