package com.example.cleanarchitecturemovieapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitecturemovieapp.domain.usecase.GetMoviesUseCase
import com.example.cleanarchitecturemovieapp.domain.usecase.UpdateMoviesUseCase

@Suppress("UNCHECKED_CAST")
class MovieViewModelFactory(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        MovieViewModel(getMoviesUseCase, updateMoviesUseCase) as T
}