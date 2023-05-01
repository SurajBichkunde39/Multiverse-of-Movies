package com.example.bookmyshowassignment.moviedetails.api

import com.example.bookmyshowassignment.moviedetails.model.Movie
import com.example.bookmyshowassignment.moviedetails.model.MovieCredits
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {
    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String
    ): Movie

    @GET("movie/{movie_id}/credits")
    suspend fun getMovieCredits(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String
    ): MovieCredits
}