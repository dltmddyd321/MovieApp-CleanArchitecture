package com.example.cleanarchitecturemovieapp.data.repository.datasource.movie

import com.example.cleanarchitecturemovieapp.data.movie.MovieResult

interface MovieCacheDataSource {

    suspend fun getMoviesFromCache(): List<MovieResult>

    suspend fun saveMoviesToCache(movies: List<MovieResult>)
}