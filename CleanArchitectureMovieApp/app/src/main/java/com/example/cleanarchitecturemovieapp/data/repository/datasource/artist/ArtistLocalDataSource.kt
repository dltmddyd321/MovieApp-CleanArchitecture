package com.example.cleanarchitecturemovieapp.data.repository.datasource.artist

import com.example.cleanarchitecturemovieapp.data.people.PeopleResult

interface ArtistLocalDataSource {
    suspend fun getArtistsFromDB(): List<PeopleResult>

    suspend fun saveArtistsToDB(artists: List<PeopleResult>)

    suspend fun clearAll()
}