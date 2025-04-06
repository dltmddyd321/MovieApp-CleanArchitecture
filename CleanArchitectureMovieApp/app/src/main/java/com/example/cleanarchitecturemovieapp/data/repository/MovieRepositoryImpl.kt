package com.example.cleanarchitecturemovieapp.data.repository

import android.util.Log
import com.example.cleanarchitecturemovieapp.data.movie.MovieResult
import com.example.cleanarchitecturemovieapp.data.repository.datasource.MovieCacheDataSource
import com.example.cleanarchitecturemovieapp.data.repository.datasource.MovieLocalDataSource
import com.example.cleanarchitecturemovieapp.data.repository.datasource.MovieRemoteDataSource
import com.example.cleanarchitecturemovieapp.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
): MovieRepository {
    override suspend fun getMovies(): List<MovieResult> = getMoviesFromCache()

    override suspend fun updateMovies(): List<MovieResult> {
        val newListOfMovies = getMoviesFromApi()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromApi(): List<MovieResult> {
        var movieList: List<MovieResult> = emptyList()
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if (response.isSuccessful && body != null) {
                movieList = body.results ?: emptyList()
            }
        } catch (e: Exception) {
            Log.e("MovieRepoImpl", e.localizedMessage ?: "")
        }
        return movieList
    }

    suspend fun getMoviesFromDB(): List<MovieResult> {
        var movieList: List<MovieResult> = emptyList()
        try {
            movieList = movieLocalDataSource.getMoviesFromDB()
        } catch (e: Exception) {
            Log.e("MovieRepoImpl", e.localizedMessage ?: "")
        }
        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromApi()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList
    }

    suspend fun getMoviesFromCache(): List<MovieResult> {
        var movieList: List<MovieResult> = emptyList()
        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        } catch (e: Exception) {
            Log.e("MovieRepoImpl", e.localizedMessage ?: "")
        }
        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }
}