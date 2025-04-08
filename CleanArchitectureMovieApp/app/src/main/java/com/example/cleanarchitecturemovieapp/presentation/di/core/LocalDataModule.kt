package com.example.cleanarchitecturemovieapp.presentation.di.core

import com.example.cleanarchitecturemovieapp.data.db.dao.ArtistDao
import com.example.cleanarchitecturemovieapp.data.db.dao.MovieDao
import com.example.cleanarchitecturemovieapp.data.db.dao.TvShowDao
import com.example.cleanarchitecturemovieapp.data.repository.datasource.artist.ArtistLocalDataSource
import com.example.cleanarchitecturemovieapp.data.repository.datasource.movie.MovieLocalDataSource
import com.example.cleanarchitecturemovieapp.data.repository.datasource.tvshow.TvShowLocalDataSource
import com.example.cleanarchitecturemovieapp.data.repository.datasourceimpl.artist.ArtistLocalDataSourceImpl
import com.example.cleanarchitecturemovieapp.data.repository.datasourceimpl.movie.MovieLocalDataSourceImpl
import com.example.cleanarchitecturemovieapp.data.repository.datasourceimpl.tvshow.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }
}