package com.example.cleanarchitecturemovieapp.presentation.viewmodel

import androidx.lifecycle.liveData
import com.example.cleanarchitecturemovieapp.domain.usecase.GetArtistUseCase
import com.example.cleanarchitecturemovieapp.domain.usecase.UpdateArtistUseCase

class ArtistViewModel(
    private val getArtistUseCase: GetArtistUseCase,
    private val updateArtistUseCase: UpdateArtistUseCase
) {

    fun getArtists() = liveData {
        val artistList = getArtistUseCase.execute()
        emit(artistList)
    }

    fun updateArtists() = liveData {
        val artistList = updateArtistUseCase.execute()
        emit(artistList)
    }

}