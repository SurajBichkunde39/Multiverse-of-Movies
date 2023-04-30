package com.example.bookmyshowassignment.repository

import com.example.bookmyshowassignment.data.model.Movie
import com.example.bookmyshowassignment.data.model.MovieCredits

interface MovieDetailsRepository {
    suspend fun getMovieDetails(movieId: Int): Movie

    suspend fun getMovieCredits(movieId: Int): MovieCredits
}