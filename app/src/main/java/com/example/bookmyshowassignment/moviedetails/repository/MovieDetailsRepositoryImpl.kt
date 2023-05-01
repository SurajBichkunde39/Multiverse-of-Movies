package com.example.bookmyshowassignment.moviedetails.repository

import com.example.bookmyshowassignment.moviedetails.api.MovieApi
import com.example.bookmyshowassignment.moviedetails.model.Movie
import com.example.bookmyshowassignment.moviedetails.model.MovieCredits
import javax.inject.Inject
import javax.inject.Named

class MovieDetailsRepositoryImpl @Inject constructor(
    private val movieApi: MovieApi,
    @Named("ApiKey") private val apiKey: String
) : MovieDetailsRepository {

    override suspend fun getMovieDetails(movieId: Int): Movie {
        return movieApi.getMovieDetails(movieId, apiKey)
    }

    override suspend fun getMovieCredits(movieId: Int): MovieCredits {
        return movieApi.getMovieCredits(movieId, apiKey)
    }
}