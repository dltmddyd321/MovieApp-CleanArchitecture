package com.example.cleanarchitecturemovieapp.data.repository

import com.example.cleanarchitecturemovieapp.data.movie.MovieResult
import com.example.cleanarchitecturemovieapp.domain.repository.MovieRepository

class FakeMovieRepository: MovieRepository {

    private val movies = mutableListOf<MovieResult>()

    init {
        val list = listOf(
            MovieResult(1, "overview1", "path1", "2024-03-11", "first"),
            MovieResult(2, "overview2", "path2", "2024-03-23", "second"),
            MovieResult(3, "overview3", "path3", "2024-06-09", "third")
        )
        movies.addAll(list)
    }

    override suspend fun getMovies(): List<MovieResult>? {
        return movies
    }

    override suspend fun updateMovies(): List<MovieResult>? {
        movies.clear()
        movies.add(MovieResult(1, "overview1", "path1", "2024-03-11", "first"))
        movies.add(MovieResult(3, "overview3", "path3", "2024-06-09", "third"))
        return movies
    }
}