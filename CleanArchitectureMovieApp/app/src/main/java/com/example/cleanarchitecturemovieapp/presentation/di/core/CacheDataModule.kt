package com.example.cleanarchitecturemovieapp.presentation.di.core

import com.example.cleanarchitecturemovieapp.data.repository.datasource.artist.ArtistCacheDataSource
import com.example.cleanarchitecturemovieapp.data.repository.datasource.movie.MovieCacheDataSource
import com.example.cleanarchitecturemovieapp.data.repository.datasource.tvshow.TvShowCacheDataSource
import com.example.cleanarchitecturemovieapp.data.repository.datasourceimpl.artist.ArtistCacheDataSourceImpl
import com.example.cleanarchitecturemovieapp.data.repository.datasourceimpl.movie.MovieCacheDataSourceImpl
import com.example.cleanarchitecturemovieapp.data.repository.datasourceimpl.tvshow.TvShowCacheDataSourceImpl
import dagger.Module

@Module
class CacheDataModule {
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }
}