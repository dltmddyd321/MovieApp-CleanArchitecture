package com.example.cleanarchitecturemovieapp.domain.repository

import com.example.cleanarchitecturemovieapp.data.tv.TvResult

interface TvShowsRepository {
    suspend fun getTvShows(): List<TvResult>?

    suspend fun updateTvShows(): List<TvResult>?
}