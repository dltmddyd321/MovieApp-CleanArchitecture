package com.example.cleanarchitecturemovieapp.presentation.viewmodel

import androidx.lifecycle.liveData
import com.example.cleanarchitecturemovieapp.domain.usecase.GetTvShowsUseCase
import com.example.cleanarchitecturemovieapp.domain.usecase.UpdateTvShowsUseCase

class TvShowViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
) {

    fun getTvShows() = liveData {
        val tvShowList = getTvShowsUseCase.execute()
        emit(tvShowList)
    }

    fun updateTvShows() = liveData {
        val tvShowList = updateTvShowsUseCase.execute()
        emit(tvShowList)
    }
}