package com.example.bookmyshowassignment.moviedetails.ui

fun String.toRequestsUrl(): String {
    val baseUrl = "https://image.tmdb.org/t/p/w300"
    return baseUrl + this
}