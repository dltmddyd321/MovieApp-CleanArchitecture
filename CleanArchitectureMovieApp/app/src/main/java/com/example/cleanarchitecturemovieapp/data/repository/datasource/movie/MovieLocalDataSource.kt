package com.example.cleanarchitecturemovieapp.data.repository.datasource.movie

import com.example.cleanarchitecturemovieapp.data.movie.MovieResult

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB(): List<MovieResult>

    suspend fun saveMoviesToDB(movies: List<MovieResult>)

    suspend fun clearAll()
}