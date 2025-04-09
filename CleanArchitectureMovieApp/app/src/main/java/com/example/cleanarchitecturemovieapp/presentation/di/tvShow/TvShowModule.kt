package com.example.cleanarchitecturemovieapp.presentation.di.tvShow

import com.example.cleanarchitecturemovieapp.domain.usecase.GetTvShowsUseCase
import com.example.cleanarchitecturemovieapp.domain.usecase.UpdateTvShowsUseCase
import com.example.cleanarchitecturemovieapp.presentation.viewmodel.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowsUseCase, updateTvShowsUseCase)
    }
}