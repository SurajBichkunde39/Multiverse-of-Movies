package com.example.bookmyshowassignment.repository

import com.example.bookmyshowassignment.data.model.Movie

interface MovieDetailsRepository {
    suspend fun getMovieDetails(movieId: Int): Movie
}