package com.example.cleanarchitecturemovieapp.data.repository.datasourceimpl.movie

import com.example.cleanarchitecturemovieapp.data.db.dao.MovieDao
import com.example.cleanarchitecturemovieapp.data.movie.MovieResult
import com.example.cleanarchitecturemovieapp.data.repository.datasource.movie.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val movieDao: MovieDao): MovieLocalDataSource {
    override suspend fun getMoviesFromDB(): List<MovieResult> =
        movieDao.getMovies()

    override suspend fun saveMoviesToDB(movies: List<MovieResult>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()
        }
    }
}