package com.example.cleanarchitecturemovieapp.domain.repository

import com.example.cleanarchitecturemovieapp.data.movie.MovieResult

interface MovieRepository {

    suspend fun getMovies(): List<MovieResult>?

    suspend fun updateMovies() : List<MovieResult>?
}