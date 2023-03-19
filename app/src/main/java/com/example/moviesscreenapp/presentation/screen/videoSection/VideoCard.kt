package com.example.moviesscreenapp.presentation.screen.videoSection

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.media3.exoplayer.ExoPlayer
import com.example.moviesscreenapp.OnClick
import com.example.moviesscreenapp.domain.models.Video
import com.example.moviesscreenapp.ui.theme.Shapes

@Composable
fun VideoCard(
    modifier: Modifier = Modifier,
    videoItem: Video,
    isPlaying: Boolean,
    exoPlayer: ExoPlayer,
    onClick: OnClick
) {
    var isPlayerUiVisible by remember { mutableStateOf(false) }
    val isPlayButtonVisible = if (isPlayerUiVisible) true else !isPlaying

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .padding(start = 15.dp, end = 15.dp)
            .size(height = 125.dp, width = 200.dp)
            .fillMaxWidth()
            .background(Color.Black, Shapes.medium)
            .clip(Shapes.medium)
            .shadow(elevation = 10.dp)
            .clip(RoundedCornerShape(5.dp))
    ) {
        if (isPlaying) {
            VideoPlayer(exoPlayer) { uiVisible ->
                isPlayerUiVisible = when {
                    isPlayerUiVisible -> uiVisible
                    else -> true
                }
            }
        } else {
            VideoThumbnail(videoItem.thumbnail)
        }
        if (isPlayButtonVisible) {
            Icon(
                painter = painterResource(if (isPlaying) com.example.moviesscreenapp.R.drawable.ic_pause else com.example.moviesscreenapp.R.drawable.ic_play),
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(50.dp)
                    .clip(remember { RoundedCornerShape(percent = 50) })
                    .clickable(onClick = onClick)
            )
        }
    }
}