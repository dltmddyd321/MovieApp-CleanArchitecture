package com.example.cleanarchitecturemovieapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitecturemovieapp.domain.usecase.GetTvShowsUseCase
import com.example.cleanarchitecturemovieapp.domain.usecase.UpdateTvShowsUseCase

@Suppress("UNCHECKED_CAST")
class TvShowViewModelFactory(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        TvShowViewModel(getTvShowsUseCase, updateTvShowsUseCase) as T
}