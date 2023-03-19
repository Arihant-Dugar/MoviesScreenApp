package com.example.moviesscreenapp.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.moviesscreenapp.domain.models.Movie
import com.example.moviesscreenapp.R
import com.example.moviesscreenapp.presentation.screen.descriptionSection.MovieDescription
import com.example.moviesscreenapp.presentation.screen.videoSection.ImageAndVideo

@Composable
fun MovieScreen() {
    Box(modifier = Modifier
        .background(Color.DarkGray)
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
    ){

        Column {
            ImageAndVideo()
            MovieDescription()
            SimilarMoviesSection(similarMovies = listOf(
                    Movie("Captain America",R.drawable.movie_1),
                    Movie("Logan",R.drawable.movie_2),
                    Movie("Avatar",R.drawable.movie_3),
                    Movie("Joker",R.drawable.movie_4),
                    Movie("Star Wars",R.drawable.movie_5),
                ))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    MovieScreen()
}