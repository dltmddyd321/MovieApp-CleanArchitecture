package com.example.cleanarchitecturemovieapp.presentation.di.movie

import com.example.cleanarchitecturemovieapp.domain.usecase.GetArtistUseCase
import com.example.cleanarchitecturemovieapp.domain.usecase.GetMoviesUseCase
import com.example.cleanarchitecturemovieapp.domain.usecase.UpdateArtistUseCase
import com.example.cleanarchitecturemovieapp.domain.usecase.UpdateMoviesUseCase
import com.example.cleanarchitecturemovieapp.presentation.viewmodel.ArtistViewModelFactory
import com.example.cleanarchitecturemovieapp.presentation.viewmodel.MovieViewModel
import com.example.cleanarchitecturemovieapp.presentation.viewmodel.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMovieUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMovieUseCase, updateMoviesUseCase)
    }
}