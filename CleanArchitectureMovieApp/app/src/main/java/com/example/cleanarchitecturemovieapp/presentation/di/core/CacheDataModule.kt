package com.example.cleanarchitecturemovieapp.presentation.di.core

import com.example.cleanarchitecturemovieapp.data.repository.datasource.artist.ArtistCacheDataSource
import com.example.cleanarchitecturemovieapp.data.repository.datasource.movie.MovieCacheDataSource
import com.example.cleanarchitecturemovieapp.data.repository.datasource.tvshow.TvShowCacheDataSource
import com.example.cleanarchitecturemovieapp.data.repository.datasourceimpl.artist.ArtistCacheDataSourceImpl
import com.example.cleanarchitecturemovieapp.data.repository.datasourceimpl.movie.MovieCacheDataSourceImpl
import com.example.cleanarchitecturemovieapp.data.repository.datasourceimpl.tvshow.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Provides
    @Singleton
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Provides
    @Singleton
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

    @Provides
    @Singleton
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }
}