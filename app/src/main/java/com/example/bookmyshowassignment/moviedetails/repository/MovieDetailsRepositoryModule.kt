package com.example.bookmyshowassignment.moviedetails.repository

import com.example.bookmyshowassignment.moviedetails.api.MovieApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieDetailsRepositoryModule {
    @Provides
    @Singleton
    fun provideMovieDetailsRepository(
        movieApi: MovieApi,
        @Named("ApiKey") apiKey: String
    ): MovieDetailsRepository {
        return MovieDetailsRepositoryImpl(movieApi, apiKey)
    }
}