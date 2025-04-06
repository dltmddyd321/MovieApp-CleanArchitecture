package com.example.cleanarchitecturemovieapp.data.repository.datasource

import com.example.cleanarchitecturemovieapp.data.movie.PopularMovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<PopularMovieList>

}