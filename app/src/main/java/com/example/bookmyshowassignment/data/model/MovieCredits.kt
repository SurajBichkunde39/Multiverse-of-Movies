package com.example.bookmyshowassignment.data.model

data class MovieCredits(
    var id: Int,
    var cast: List<Cast>,
    var crew: List<Crew>,
)
