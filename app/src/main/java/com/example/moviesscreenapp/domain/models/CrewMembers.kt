package com.example.moviesscreenapp.domain.models

import androidx.annotation.DrawableRes

data class CrewMembers(
    val name : String,
    @DrawableRes val crewImg : Int
)
