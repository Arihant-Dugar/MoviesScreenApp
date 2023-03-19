package com.example.moviesscreenapp.domain.models

data class Video(
    val id: Int,
    val title: String,
    val uri: String,
    val thumbnail: Int,
    val lastPlayedPosition:Long = 0
)
