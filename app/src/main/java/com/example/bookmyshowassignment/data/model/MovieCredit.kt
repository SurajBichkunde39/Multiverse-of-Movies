package com.example.bookmyshowassignment.data.model

/**
 * Movie credit could be either industrial cast or a crew member.
 */
data class MovieCredit(
    val personName: String,
    val imageUrl: String,
    val roleInMovie: String
)
