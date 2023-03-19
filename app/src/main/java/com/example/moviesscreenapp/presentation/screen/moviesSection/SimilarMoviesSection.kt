package com.example.moviesscreenapp.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviesscreenapp.domain.models.Movie
import com.example.moviesscreenapp.R

@Composable
fun SimilarMoviesSection(similarMovies : List<Movie>) {
    Box (
        modifier = Modifier
            .padding(start = 15.dp, bottom = 15.dp)
            .fillMaxWidth()
    ){
        Column {
            Text (
                modifier = Modifier.padding(bottom = 15.dp),
                text = stringResource(R.string.title_similar_movies),
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.Medium
            )
            LazyRow {
                items(similarMovies.size) {
                    Box(
                        modifier = Modifier
                            .padding(end = 15.dp)
                            .fillMaxSize()
                    ){
                        SimilarMovies(similarMovies[it])
                    }
                }
            }
        }
    }
}

@Composable
fun SimilarMovies(movies: Movie) {
    Image(
        painter = painterResource(id = movies.similarMovie),
        contentDescription = movies.title,
        modifier = Modifier.size(height = 250.dp, width = 150.dp)
    )
}