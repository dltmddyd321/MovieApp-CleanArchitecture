package com.example.cleanarchitecturemovieapp.presentation.di.core

import com.example.cleanarchitecturemovieapp.data.repository.datasource.artist.ArtistCacheDataSource
import com.example.cleanarchitecturemovieapp.data.repository.datasource.artist.ArtistLocalDataSource
import com.example.cleanarchitecturemovieapp.data.repository.datasource.artist.ArtistRemoteDataSource
import com.example.cleanarchitecturemovieapp.data.repository.datasource.movie.MovieCacheDataSource
import com.example.cleanarchitecturemovieapp.data.repository.datasource.movie.MovieLocalDataSource
import com.example.cleanarchitecturemovieapp.data.repository.datasource.movie.MovieRemoteDataSource
import com.example.cleanarchitecturemovieapp.data.repository.datasource.tvshow.TvShowCacheDataSource
import com.example.cleanarchitecturemovieapp.data.repository.datasource.tvshow.TvShowLocalDataSource
import com.example.cleanarchitecturemovieapp.data.repository.datasource.tvshow.TvShowRemoteDataSource
import com.example.cleanarchitecturemovieapp.data.repository.respositoryimpl.ArtistRepositoryImpl
import com.example.cleanarchitecturemovieapp.data.repository.respositoryimpl.MovieRepositoryImpl
import com.example.cleanarchitecturemovieapp.data.repository.respositoryimpl.TvShowRepositoryImpl
import com.example.cleanarchitecturemovieapp.domain.repository.ArtistRepository
import com.example.cleanarchitecturemovieapp.domain.repository.MovieRepository
import com.example.cleanarchitecturemovieapp.domain.repository.TvShowsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource, movieLocalDataSource, movieCacheDataSource
        )
    }

    @Provides
    @Singleton
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowsRepository {
        return TvShowRepositoryImpl(
            tvShowRemoteDataSource, tvShowLocalDataSource, tvShowCacheDataSource
        )
    }

    @Provides
    @Singleton
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {
        return ArtistRepositoryImpl(
            artistRemoteDataSource, artistLocalDataSource, artistCacheDataSource
        )
    }
}