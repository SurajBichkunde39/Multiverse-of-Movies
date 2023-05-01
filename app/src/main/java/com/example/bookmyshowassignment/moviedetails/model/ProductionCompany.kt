package com.example.bookmyshowassignment.moviedetails.model

import com.squareup.moshi.Json

data class ProductionCompany(
    var name: String,
    var id: Int,
    @Json(name = "logo_path")
    var logoPath: String?,
    @Json(name = "origin_country")
    var originCountry: String
)
