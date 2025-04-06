package com.example.cleanarchitecturemovieapp.data.repository.datasource.tvshow

import com.example.cleanarchitecturemovieapp.data.tv.TvResult

interface TvShowCacheDataSource {

    suspend fun getTvShowsFromCache(): List<TvResult>

    suspend fun saveTvShowsToCache(tvShows: List<TvResult>)
}