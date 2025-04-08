package com.example.cleanarchitecturemovieapp.presentation.di.core

import com.example.cleanarchitecturemovieapp.data.api.ApiService
import com.example.cleanarchitecturemovieapp.data.repository.datasource.artist.ArtistRemoteDataSource
import com.example.cleanarchitecturemovieapp.data.repository.datasource.movie.MovieRemoteDataSource
import com.example.cleanarchitecturemovieapp.data.repository.datasource.tvshow.TvShowRemoteDataSource
import com.example.cleanarchitecturemovieapp.data.repository.datasourceimpl.artist.ArtistRemoteDataSourceImpl
import com.example.cleanarchitecturemovieapp.data.repository.datasourceimpl.movie.MovieRemoteDataSourceImpl
import com.example.cleanarchitecturemovieapp.data.repository.datasourceimpl.tvshow.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: ApiService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideTvRemoteDataSource(tmdbService: ApiService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: ApiService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(tmdbService, apiKey)
    }

}