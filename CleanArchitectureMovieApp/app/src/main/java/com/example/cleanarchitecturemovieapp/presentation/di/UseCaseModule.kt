package com.example.cleanarchitecturemovieapp.presentation.di

import com.example.cleanarchitecturemovieapp.domain.repository.ArtistRepository
import com.example.cleanarchitecturemovieapp.domain.repository.MovieRepository
import com.example.cleanarchitecturemovieapp.domain.repository.TvShowsRepository
import com.example.cleanarchitecturemovieapp.domain.usecase.GetArtistUseCase
import com.example.cleanarchitecturemovieapp.domain.usecase.GetMoviesUseCase
import com.example.cleanarchitecturemovieapp.domain.usecase.GetTvShowsUseCase
import com.example.cleanarchitecturemovieapp.domain.usecase.UpdateArtistUseCase
import com.example.cleanarchitecturemovieapp.domain.usecase.UpdateMoviesUseCase
import com.example.cleanarchitecturemovieapp.domain.usecase.UpdateTvShowsUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }

    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase {
        return UpdateMoviesUseCase(movieRepository)
    }


    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TvShowsRepository): GetTvShowsUseCase {
        return GetTvShowsUseCase(tvShowRepository)
    }

    fun provideUpdateTvShowUseCase(tvShowRepository: TvShowsRepository): UpdateTvShowsUseCase {
        return UpdateTvShowsUseCase(tvShowRepository)
    }


    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository): GetArtistUseCase {
        return GetArtistUseCase(artistRepository)
    }

    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository): UpdateArtistUseCase {
        return UpdateArtistUseCase(artistRepository)
    }
}