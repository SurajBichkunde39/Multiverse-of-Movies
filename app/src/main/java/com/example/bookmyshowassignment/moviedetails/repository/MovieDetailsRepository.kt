package com.example.bookmyshowassignment.moviedetails.repository

import com.example.bookmyshowassignment.moviedetails.model.Movie
import com.example.bookmyshowassignment.moviedetails.model.MovieCredits

interface MovieDetailsRepository {

    /**
     * Asynchronously retrieves the movie details for the specified movie ID.
     *
     * @param movieId The ID of the movie to retrieve details for.
     * @return The movie details as a [Movie] object.
     */
    suspend fun getMovieDetails(movieId: Int): Movie

    /**
     * Asynchronously retrieves the cast and crew credits for a given movie ID from
     * data source.
     *
     *  @param movieId The ID of the movie to retrieve credits for
     *  @return A [MovieCredits] object containing the cast and crew for the specified movie.
     */
    suspend fun getMovieCredits(movieId: Int): MovieCredits
}