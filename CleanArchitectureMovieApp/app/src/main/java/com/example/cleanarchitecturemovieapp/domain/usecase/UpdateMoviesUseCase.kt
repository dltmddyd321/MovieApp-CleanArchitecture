package com.example.cleanarchitecturemovieapp.domain.usecase

import com.example.cleanarchitecturemovieapp.data.movie.MovieResult
import com.example.cleanarchitecturemovieapp.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute(): List<MovieResult>? = movieRepository.updateMovies()
}