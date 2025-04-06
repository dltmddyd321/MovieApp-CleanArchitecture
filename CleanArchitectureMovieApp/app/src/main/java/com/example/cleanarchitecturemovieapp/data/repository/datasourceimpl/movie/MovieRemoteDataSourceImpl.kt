package com.example.cleanarchitecturemovieapp.data.repository.datasourceimpl.movie

import com.example.cleanarchitecturemovieapp.data.api.ApiService
import com.example.cleanarchitecturemovieapp.data.movie.PopularMovieList
import com.example.cleanarchitecturemovieapp.data.repository.datasource.movie.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val apiService: ApiService,
    private val apiKey: String
) : MovieRemoteDataSource {
    override suspend fun getMovies(): Response<PopularMovieList> = apiService.getPopularMovies(apiKey)
}