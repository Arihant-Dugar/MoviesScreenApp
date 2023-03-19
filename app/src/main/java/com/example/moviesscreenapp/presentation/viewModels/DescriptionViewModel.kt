package com.example.moviesscreenapp.presentation.viewModels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DescriptionViewModel @Inject constructor() : ViewModel(){

    var isExpanded = mutableStateOf(false)

}