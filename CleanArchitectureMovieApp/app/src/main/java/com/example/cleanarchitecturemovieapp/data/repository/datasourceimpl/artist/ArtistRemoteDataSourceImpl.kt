package com.example.cleanarchitecturemovieapp.data.repository.datasourceimpl.artist

import com.example.cleanarchitecturemovieapp.data.api.ApiService
import com.example.cleanarchitecturemovieapp.data.movie.PopularMovieList
import com.example.cleanarchitecturemovieapp.data.people.PeopleList
import com.example.cleanarchitecturemovieapp.data.repository.datasource.artist.ArtistRemoteDataSource
import com.example.cleanarchitecturemovieapp.data.repository.datasource.movie.MovieRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val apiService: ApiService,
    private val apiKey: String
) : ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<PeopleList> = apiService.getPopularArtists(apiKey)
}