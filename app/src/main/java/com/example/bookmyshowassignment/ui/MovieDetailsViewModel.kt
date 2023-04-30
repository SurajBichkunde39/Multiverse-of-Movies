package com.example.bookmyshowassignment.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookmyshowassignment.data.model.Cast
import com.example.bookmyshowassignment.data.model.Crew
import com.example.bookmyshowassignment.data.model.Movie
import com.example.bookmyshowassignment.repository.MovieDetailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val repository: MovieDetailsRepository
) : ViewModel() {

    private val _movieDetails = MutableLiveData<Movie>()
    val movieDetails: LiveData<Movie> = _movieDetails

    private val _cast = MutableLiveData<List<Cast>>()
    val cast: LiveData<List<Cast>> = _cast

    private val _crew = MutableLiveData<List<Crew>>()
    val crew: LiveData<List<Crew>> = _crew

    fun loadMovieDetails(movieId: Int) {
        viewModelScope.launch {
            _movieDetails.value = repository.getMovieDetails(movieId)
            val movieCredits = repository.getMovieCredits(movieId)
            _cast.value = movieCredits.cast
            _crew.value = movieCredits.crew
            Log.d("MovieDetailsViewModel", cast.value.toString())
            Log.d("MovieDetailsViewModel", crew.value.toString())
        }
    }
}