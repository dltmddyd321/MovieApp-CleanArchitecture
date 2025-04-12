package com.example.cleanarchitecturemovieapp.data.repository.respositoryimpl

import android.util.Log
import com.example.cleanarchitecturemovieapp.data.movie.MovieResult
import com.example.cleanarchitecturemovieapp.data.repository.datasource.movie.MovieCacheDataSource
import com.example.cleanarchitecturemovieapp.data.repository.datasource.movie.MovieLocalDataSource
import com.example.cleanarchitecturemovieapp.data.repository.datasource.movie.MovieRemoteDataSource
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
        Log.i("진입 검사", "여기로 진입했는가? 1")
        lateinit var movieList: List<MovieResult>
        try {
            Log.i("진입 검사", "여기로 진입했는가? 2")
            val response = movieRemoteDataSource.getMovies()
            Log.i("진입 검사", "여기로 진입했는가? 3-1")
            response.body()?.let { movieList = it.results }
        } catch (e: Exception) {
            Log.e("MovieRepoImpl", e.toString())
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