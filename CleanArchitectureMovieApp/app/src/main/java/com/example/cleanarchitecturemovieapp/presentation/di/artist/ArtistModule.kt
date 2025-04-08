package com.example.cleanarchitecturemovieapp.presentation.di.artist

import com.example.cleanarchitecturemovieapp.domain.usecase.GetArtistUseCase
import com.example.cleanarchitecturemovieapp.domain.usecase.UpdateArtistUseCase
import com.example.cleanarchitecturemovieapp.presentation.viewmodel.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistUseCase: GetArtistUseCase,
        updateArtistUseCase: UpdateArtistUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(getArtistUseCase, updateArtistUseCase)
    }
}