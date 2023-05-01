package com.example.bookmyshowassignment.moviedetails.model

import com.squareup.moshi.Json

data class Cast(
    var adult: Boolean,
    var gender: Int,
    var id: Int,
    @Json(name = "known_for_department")
    var knownForDepartment: String,
    var name: String,
    @Json(name = "original_name")
    var originalName: String,
    var popularity: Float,
    @Json(name = "profile_path")
    var profilePath: String?,
    @Json(name = "cast_id")
    var castId: Int,
    var character: String,
    @Json(name = "credit_id")
    var creditId: String,
    var order: Int
)
