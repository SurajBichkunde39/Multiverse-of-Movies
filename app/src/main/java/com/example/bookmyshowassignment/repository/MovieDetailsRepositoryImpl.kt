package com.example.bookmyshowassignment.repository

import com.example.bookmyshowassignment.api.MovieApi
import com.example.bookmyshowassignment.data.model.Movie
import javax.inject.Inject
import javax.inject.Named

class MovieDetailsRepositoryImpl @Inject constructor(
    private val movieApi: MovieApi,
    @Named("ApiKey") private val apiKey: String
) : MovieDetailsRepository {

    override suspend fun getMovieDetails(movieId: Int): Movie {
        return movieApi.getMovieDetails(movieId, apiKey)
    }
}