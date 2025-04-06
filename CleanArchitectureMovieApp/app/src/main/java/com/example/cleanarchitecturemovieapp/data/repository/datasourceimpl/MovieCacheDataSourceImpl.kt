package com.example.cleanarchitecturemovieapp.data.repository.datasourceimpl

import com.example.cleanarchitecturemovieapp.data.movie.MovieResult
import com.example.cleanarchitecturemovieapp.data.repository.datasource.MovieCacheDataSource
import java.util.Collections

class MovieCacheDataSourceImpl: MovieCacheDataSource {

    private var movieList = Collections.synchronizedList(mutableListOf<MovieResult>())

    override suspend fun getMoviesFromCache(): List<MovieResult> = movieList

    override suspend fun saveMoviesToCache(movies: List<MovieResult>) {
        movieList.clear()
        movieList.addAll(movies)
    }
}