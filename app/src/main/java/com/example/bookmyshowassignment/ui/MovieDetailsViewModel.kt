package com.example.bookmyshowassignment.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookmyshowassignment.repository.MovieDetailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val repository: MovieDetailsRepository
) : ViewModel() {

    fun loadMovieDetails(movieId: Int) {
        viewModelScope.launch {
            val movie = repository.getMovieDetails(movieId)
            Log.d("SOMETHING", movie.toString())
        }
    }
}