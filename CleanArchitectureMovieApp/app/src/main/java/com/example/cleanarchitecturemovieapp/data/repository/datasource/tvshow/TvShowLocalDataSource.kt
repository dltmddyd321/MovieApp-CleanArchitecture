package com.example.cleanarchitecturemovieapp.data.repository.datasource.tvshow

import com.example.cleanarchitecturemovieapp.data.tv.TvResult

interface TvShowLocalDataSource {
    suspend fun getTvShowsFromDB(): List<TvResult>

    suspend fun saveTvShowsToDB(tvShows: List<TvResult>)

    suspend fun clearAll()
}