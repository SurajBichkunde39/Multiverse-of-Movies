package com.example.bookmyshowassignment.data.model

import com.google.gson.annotations.SerializedName

data class Movie(
    var adult: Boolean,
    @SerializedName("belongs_to_collection")
    var belongsToCollection: BelongsToCollection?,
    var budget: Int,
    var genres: List<Genre>,
    var homepage: String?,
    var id: Int,
    @SerializedName("imdb_id")
    var imdbId: String,
    @SerializedName("original_language")
    var originalLanguage: String,
    @SerializedName("original_title")
    var originalTitle: String,
    var overview: String,
    var popularity: String,
    @SerializedName("poster_path")
    var posterPath: String,
    @SerializedName("production_companies")
    var productionCompanies: List<ProductionCompany>,
    @SerializedName("production_countries")
    var productionCountries: List<ProductionCounty>,
    @SerializedName("release_date")
    var releaseDate: String,
    var revenue: Int,
    var runtime: Int,
    @SerializedName("spoken_languages")
    var spokenLanguages: List<SpokenLanguage>,
    var status: String,
    var tagline: String?,
    var title: String,
    var video: Boolean,
    @SerializedName("vote_average")
    var voteAverage: Int,
    @SerializedName("vote_count")
    var voteCount: Int
)
