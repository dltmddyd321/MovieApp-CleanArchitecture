package com.example.cleanarchitecturemovieapp.data.api

import com.example.cleanarchitecturemovieapp.data.movie.PopularMovieList
import com.example.cleanarchitecturemovieapp.data.people.PeopleList
import com.example.cleanarchitecturemovieapp.data.tv.TvList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apikey: String
    ): Response<PopularMovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(
        @Query("api_key") apikey: String
    ): Response<TvList>

    @GET("person/popular")
    suspend fun getPopularArtists(
        @Query("api_key") apikey: String
    ): Response<PeopleList>
}