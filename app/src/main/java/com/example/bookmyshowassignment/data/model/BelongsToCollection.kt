package com.example.bookmyshowassignment.data.model

import com.squareup.moshi.Json

data class BelongsToCollection(
    var id: Int,
    var name: String,
    @Json(name = "poster_path")
    var posterPath: String?,
    @Json(name = "backdrop_path")
    var backdropPath: String?
)
