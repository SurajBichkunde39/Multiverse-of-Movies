package com.example.bookmyshowassignment.data.model

import com.squareup.moshi.Json

data class Crew(
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
    @Json(name = "credit_id")
    var creditId: String,
    var department: String,
    var job: String
)
