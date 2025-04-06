package com.example.cleanarchitecturemovieapp.data.repository.datasource.tvshow

import com.example.cleanarchitecturemovieapp.data.tv.TvList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShows(): Response<TvList>
}