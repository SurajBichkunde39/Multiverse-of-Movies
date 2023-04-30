package com.example.bookmyshowassignment.data.model

import com.squareup.moshi.Json

data class Movie(
    var adult: Boolean,
    @Json(name = "backdrop_path")
    var backdropPath: String?,
    @Json(name = "belongs_to_collection")
    var belongsToCollection: BelongsToCollection?,
    var budget: Int,
    var genres: List<Genre>,
    var homepage: String?,
    var id: Int,
    @Json(name = "imdb_id")
    var imdbId: String,
    @Json(name = "original_language")
    var originalLanguage: String,
    @Json(name = "original_title")
    var originalTitle: String,
    var overview: String,
    var popularity: String,
    @Json(name = "poster_path")
    var posterPath: String,
    @Json(name = "production_companies")
    var productionCompanies: List<ProductionCompany>,
    @Json(name = "production_countries")
    var productionCountries: List<ProductionCounty>,
    @Json(name = "release_date")
    var releaseDate: String,
    var revenue: Int,
    var runtime: Int,
    @Json(name = "spoken_languages")
    var spokenLanguages: List<SpokenLanguage>,
    var status: String,
    var tagline: String?,
    var title: String,
    var video: Boolean,
    @Json(name = "vote_average")
    var voteAverage: Float,
    @Json(name = "vote_count")
    var voteCount: Int
)
