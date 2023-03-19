package com.example.moviesscreenapp.presentation.screen.descriptionSection

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.moviesscreenapp.R
import com.example.moviesscreenapp.domain.models.CastMembers
import com.example.moviesscreenapp.domain.models.CrewMembers
import com.example.moviesscreenapp.presentation.viewModels.DescriptionViewModel
import com.example.moviesscreenapp.ui.theme.*

@Composable
fun MovieDescription(viewModel: DescriptionViewModel = hiltViewModel()) {

    var isExpanded by viewModel.isExpanded

    ConstraintLayout {
        val (heart) = createRefs()
        Box(
            modifier = Modifier
                .padding(15.dp)
                .background(Color.White)
                .padding(start = 20.dp, top = 20.dp, bottom = 15.dp, end = 15.dp)
                .fillMaxWidth()
        ){
            Column {
                // 1ST COLUMN CONTENT
                Column(modifier = Modifier.padding(bottom = 20.dp))
                {
                    Text(
                        modifier = Modifier.padding(bottom = 8.dp),
                        text = stringResource(R.string.movie_name),
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.h4,
                        fontSize = 18.sp
                    )
                    Row (
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        // 1st Item Of Row
                        Box(
                            modifier = Modifier
                                .padding(end = 15.dp)
                                .background(Yellow)
                                .padding(start = 8.dp, end = 8.dp)
                        ){
                            Row (
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ){
                                Text(
                                    text = stringResource(R.string.imdb),
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold
                                )
                                Spacer(modifier = Modifier.width(5.dp))
                                Icon(
                                    modifier = Modifier
                                        .size(14.dp),
                                    painter = painterResource(id = R.drawable.ic_star),
                                    contentDescription = stringResource(R.string.star_rating_icon),
                                    tint = Color.White
                                )
                            }
                        }
                        // 2nd Item of the Row
                        Column {
                            Row (
                                Modifier.padding(bottom = 5.dp),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ){
                                Box(
                                    modifier = Modifier
                                        .padding(top = 22.dp, end = 8.dp)
                                        .background(LightPink)
                                        .padding(start = 8.dp, end = 8.dp)
                                ) {
                                    Text(
                                        text = stringResource(R.string.action),
                                        color = Color.White,
                                        fontWeight = FontWeight.Medium
                                    )
                                }
                                Box(
                                    modifier = Modifier
                                        .padding(top = 22.dp, end = 8.dp)
                                        .background(Earthy)
                                        .padding(start = 8.dp, end = 8.dp)
                                ) {
                                    Text(
                                        text = stringResource(R.string.thriller),
                                        color = Color.White,
                                        fontWeight = FontWeight.Medium
                                    )
                                }
                            }
                            Box(
                                modifier = Modifier
                                    .padding(end = 8.dp)
                                    .background(Beige)
                                    .padding(start = 8.dp, end = 8.dp)
                            ) {
                                Text(
                                    text = stringResource(R.string.science_fiction),
                                    color = Color.White,
                                    fontWeight = FontWeight.Medium
                                )
                            }
                        }
                    }
                }
                // 2 COLUMN CONTENT
                Box(
                    modifier = Modifier
                        .padding(bottom = 20.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.movie_description),
                        color = Color.Black,
                        fontWeight = FontWeight.Normal,
                        maxLines = 3
                    )
                }
                // 3 COLUMN CONTENT
                Row (
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Box(
                        modifier = Modifier
                            .padding(end = 20.dp)
                            .background(MyBlue)
                            .padding(start = 8.dp, end = 8.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.post_production),
                            color = Color.White,
                            fontWeight = FontWeight.Medium
                        )
                    }
                    Box(
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                    ){
                        Text(
                            text = stringResource(R.string.date),
                            color = Color.Black,
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                }

                Box(modifier = Modifier
                    .align(Alignment.End)
                ) {
                    Text(
                        modifier = Modifier.clickable {
                            isExpanded = !isExpanded
                        },
                        text = if(isExpanded) "READ LESS" else "READ MORE",
                        color = MyBlue,
                        fontWeight = FontWeight.Normal
                    )
                }
                // 4 COLUMN CONTENT
                // cast and crew
                AnimatedVisibility(visible = isExpanded) {
                    Column {
                        Cast(
                            cast = listOf(
                                CastMembers("Robert Downey Jr. \n / Ironman", R.drawable.ironman),
                                CastMembers("Mark Ruffalo \n / Hulk", R.drawable.hulk),
                                CastMembers("Scarlett Johansson \n / Black Widow", R.drawable.natasha),
                                CastMembers("Chris Evans \n / Captain America", R.drawable.captainamerica),
                                CastMembers("Chris Hemsworth \n / Thor", R.drawable.thor),
                                CastMembers("Brie Larson \n / Captain Marvel", R.drawable.captainmarvel),
                                CastMembers("Chadwick Boseman \n / Black Panther", R.drawable.blackpanther),
                                CastMembers("Elisabeth Olsen \n / Wanda", R.drawable.wanda)
                            )
                        )
                        Crew(
                            crew = listOf(
                                CrewMembers("Stan Lee", R.drawable.stanlee),
                                CrewMembers("James Gunn", R.drawable.jamesgunn),
                                CrewMembers("Mathew Gatlin", R.drawable.ic_person),
                                CrewMembers("Anthony Russo", R.drawable.anthonyrusso),
                                CrewMembers("Joe Russo", R.drawable.joerusso),
                                CrewMembers("Mike Stallion", R.drawable.ic_person),
                                CrewMembers("Jon Favreau", R.drawable.jonfavreau),
                                CrewMembers("Thomas Brown", R.drawable.ic_person),
                            )
                        )
                    }
                }
            }
        }
        Box (
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(start = 240.dp)
                .constrainAs(heart) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .clip(CircleShape)
                .size(40.dp)
                .background(Color.LightGray)
        ){
            Image(
                painter = painterResource(id = R.drawable.heart),
                contentDescription = "heart",
                modifier = Modifier
                    .background(Color.Transparent)
            )
        }
    }
}

@Composable
fun Cast(cast : List<CastMembers>) {
    Box (
        modifier = Modifier
            .padding(top = 15.dp, bottom = 15.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ){
        Column {
            Text (
                text = stringResource(R.string.title_cast),
                fontSize = 14.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            Divider(color = Color.Gray, thickness = 2.dp,modifier = Modifier.padding(bottom = 15.dp))
            LazyRow {
                items(cast.size) {
                    Box(
                        modifier = Modifier
                            .padding(end = 15.dp)
                            .fillMaxSize()
                    ){
                        CastList(cast[it])
                    }
                }
            }
        }
    }
}

@Composable
fun CastList(castMembers: CastMembers) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = castMembers.castImg),
            contentDescription = castMembers.name,
            modifier = Modifier
                .clip(CircleShape)
                .size(75.dp)
        )
        Text(
            modifier = Modifier
                .padding(top = 3.dp),
            text = castMembers.name,
            fontWeight = FontWeight.Normal,
            fontSize = 10.sp
        )
    }
}

@Composable
fun Crew(crew : List<CrewMembers>) {
    Box (
        modifier = Modifier
            .padding(bottom = 15.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ){
        Column {
            Text (
                text = stringResource(R.string.title_crew),
                fontSize = 14.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            Divider(color = Color.Gray, thickness = 2.dp,modifier = Modifier.padding(bottom = 15.dp))
            LazyRow {
                items(crew.size) {
                    Box(
                        modifier = Modifier
                            .padding(end = 15.dp)
                            .fillMaxSize()
                    ){
                        CrewList(crew[it])
                    }
                }
            }
        }
    }
}

@Composable
fun CrewList(crewMembers: CrewMembers) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = crewMembers.crewImg),
            contentDescription = crewMembers.name,
            modifier = Modifier
                .clip(CircleShape)
                .size(75.dp)
        )
        Text(
            modifier = Modifier
                .padding(top = 3.dp),
            text = crewMembers.name,
            fontWeight = FontWeight.Normal,
            fontSize = 10.sp
        )
    }
}