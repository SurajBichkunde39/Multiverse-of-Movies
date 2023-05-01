package com.example.bookmyshowassignment.moviedetails.ui

import androidx.lifecycle.*
import com.example.bookmyshowassignment.moviedetails.model.Cast
import com.example.bookmyshowassignment.moviedetails.model.Crew
import com.example.bookmyshowassignment.moviedetails.model.Movie
import com.example.bookmyshowassignment.moviedetails.model.MovieCredit
import com.example.bookmyshowassignment.moviedetails.repository.MovieDetailsRepository
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
    val cast: LiveData<List<MovieCredit>> = _cast.map { castMembers ->
        castMembers.filter { it.profilePath != null }.map {
            MovieCredit(it.name, it.profilePath!!.toRequestsUrl(), it.character)
        }
    }

    private val _crew = MutableLiveData<List<Crew>>()
    val crew: LiveData<List<MovieCredit>> = _crew.map { crewMembers ->
        crewMembers.filter { it.profilePath != null }.map {
            MovieCredit(it.name, it.profilePath!!.toRequestsUrl(), it.department)
        }
    }

    fun loadData(movieId: Int) {
        loadMovieDetails(movieId)
        loadCastAndCrewDetails(movieId)
    }

    private fun loadMovieDetails(movieId: Int) {
        viewModelScope.launch {
            _movieDetails.value = repository.getMovieDetails(movieId)
        }
    }

    private fun loadCastAndCrewDetails(movieId: Int) {
        viewModelScope.launch {
            val movieCredits = repository.getMovieCredits(movieId)
            _cast.value = movieCredits.cast
            _crew.value = movieCredits.crew
        }
    }
}