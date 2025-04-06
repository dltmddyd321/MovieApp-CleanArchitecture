package com.example.cleanarchitecturemovieapp.domain.usecase

import com.example.cleanarchitecturemovieapp.data.tv.TvResult
import com.example.cleanarchitecturemovieapp.domain.repository.TvShowsRepository

class UpdateTvShowsUseCase(private val tvShowsRepository: TvShowsRepository) {
    suspend fun execute(): List<TvResult>? = tvShowsRepository.updateTvShows()
}