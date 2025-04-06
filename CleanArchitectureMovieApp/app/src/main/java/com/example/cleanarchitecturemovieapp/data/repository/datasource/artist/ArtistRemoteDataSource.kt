package com.example.cleanarchitecturemovieapp.data.repository.datasource.artist

import com.example.cleanarchitecturemovieapp.data.people.PeopleList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<PeopleList>

}