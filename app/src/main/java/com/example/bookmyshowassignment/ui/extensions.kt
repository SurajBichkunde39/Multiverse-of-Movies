package com.example.bookmyshowassignment.ui

fun String.toRequestsUrl(): String {
    val baseUrl = "https://image.tmdb.org/t/p/w300"
    return baseUrl + this
}