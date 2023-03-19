package com.example.moviesscreenapp.presentation.screen.videoSection

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.moviesscreenapp.R

@Composable
fun ImageAndVideo() {
    ConstraintLayout {
        val (bgImg,Movies) = createRefs()
        Box(
            modifier = Modifier
                .constrainAs(bgImg){
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ){
            Image(
                painter = painterResource(id = R.drawable.bg_image),
                contentDescription = "background image",
                contentScale = ContentScale.FillHeight
            )
        }
        Box(
            modifier = Modifier
                .padding(top = 240.dp)
                .constrainAs(Movies) {
                    top.linkTo(parent.top)
                }
        ){
            VideosScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ImageAndVideoPreview() {
    ImageAndVideo()
}

