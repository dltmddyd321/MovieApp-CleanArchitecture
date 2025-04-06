package com.example.cleanarchitecturemovieapp.data.repository.datasource.artist

import com.example.cleanarchitecturemovieapp.data.people.PeopleResult

interface ArtistCacheDataSource {

    suspend fun getArtistsFromCache(): List<PeopleResult>

    suspend fun saveArtistsToCache(artists: List<PeopleResult>)
}