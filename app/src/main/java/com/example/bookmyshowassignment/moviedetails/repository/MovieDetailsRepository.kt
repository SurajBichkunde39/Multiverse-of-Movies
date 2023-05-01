package com.example.bookmyshowassignment.moviedetails.repository

import com.example.bookmyshowassignment.moviedetails.model.Movie
import com.example.bookmyshowassignment.moviedetails.model.MovieCredits

interface MovieDetailsRepository {
    suspend fun getMovieDetails(movieId: Int): Movie

    suspend fun getMovieCredits(movieId: Int): MovieCredits
}