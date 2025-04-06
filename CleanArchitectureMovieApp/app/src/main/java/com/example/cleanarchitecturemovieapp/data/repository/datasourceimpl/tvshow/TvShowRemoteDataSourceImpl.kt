package com.example.cleanarchitecturemovieapp.data.repository.datasourceimpl.tvshow

import com.example.cleanarchitecturemovieapp.data.api.ApiService
import com.example.cleanarchitecturemovieapp.data.movie.PopularMovieList
import com.example.cleanarchitecturemovieapp.data.repository.datasource.movie.MovieRemoteDataSource
import com.example.cleanarchitecturemovieapp.data.repository.datasource.tvshow.TvShowRemoteDataSource
import com.example.cleanarchitecturemovieapp.data.tv.TvList
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val apiService: ApiService,
    private val apiKey: String
) : TvShowRemoteDataSource {
    override suspend fun getTvShows(): Response<TvList> = apiService.getPopularTvShows(apiKey)
}