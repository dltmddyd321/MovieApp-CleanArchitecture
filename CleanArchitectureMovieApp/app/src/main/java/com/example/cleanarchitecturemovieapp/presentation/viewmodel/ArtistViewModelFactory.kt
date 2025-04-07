package com.example.cleanarchitecturemovieapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitecturemovieapp.domain.usecase.GetArtistUseCase
import com.example.cleanarchitecturemovieapp.domain.usecase.UpdateArtistUseCase

@Suppress("UNCHECKED_CAST")
class ArtistViewModelFactory(
    private val getArtistUseCase: GetArtistUseCase,
    private val updateArtistUseCase: UpdateArtistUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        ArtistViewModel(getArtistUseCase, updateArtistUseCase) as T
}