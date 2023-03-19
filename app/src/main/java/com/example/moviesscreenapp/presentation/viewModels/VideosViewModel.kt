package com.example.moviesscreenapp.presentation.viewModels

import androidx.lifecycle.ViewModel
import com.example.moviesscreenapp.R
import com.example.moviesscreenapp.domain.models.Video
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class VideosViewModel @Inject constructor() : ViewModel() {

    val videos = MutableStateFlow<List<Video>>(listOf())
    val currentlyPlayingIndex = MutableStateFlow<Int?>(null)

    init {
        populateListWithFakeData()
    }

    private fun populateListWithFakeData() {
        val testVideos = listOf(
            Video(
                1,
                "first_video",
                "android.resource://" + "com.example.moviesscreenapp" + "/" + R.raw.first_video,
                thumbnail = R.drawable.thumbnail_1
            ),
            Video(
                2,
                "second_video",
                "android.resource://" + "com.example.moviesscreenapp" + "/" + R.raw.second_video,
                thumbnail = R.drawable.thumbnail_2
            ),
            Video(
                3,
                "third_video",
                "android.resource://" + "com.example.moviesscreenapp" + "/" + R.raw.third_video,
                thumbnail = R.drawable.thumbnail_3
            ),
            Video(
                4,
                "fourth_video",
                "android.resource://" + "com.example.moviesscreenapp" + "/" + R.raw.fourth_video,
                thumbnail = R.drawable.thumbnail_4
            ),
            Video(
                5,
                "fifth_video",
                "android.resource://" + "com.example.moviesscreenapp" + "/" + R.raw.fifth_video,
                thumbnail = R.drawable.thumbnail_5
            )
        )
        videos.value = testVideos
    }

    fun onPlayVideoClick(playbackPosition: Long, videoIndex: Int) {
        when (currentlyPlayingIndex.value) {
            // video is not playing at the moment
            null -> currentlyPlayingIndex.value = videoIndex
            // this video is already playing
            videoIndex -> {
                currentlyPlayingIndex.value = null
                videos.value = videos.value.toMutableList().also { list ->
                    list[videoIndex] = list[videoIndex].copy(lastPlayedPosition = playbackPosition)
                }
            }
            // video is playing, and we're requesting new video to play
            else -> {
                videos.value = videos.value.toMutableList().also { list ->
                    list[currentlyPlayingIndex.value!!] =
                        list[currentlyPlayingIndex.value!!].copy(lastPlayedPosition = playbackPosition)
                }
                currentlyPlayingIndex.value = videoIndex
            }
        }
    }
}