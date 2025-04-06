package com.example.cleanarchitecturemovieapp.domain.repository

import com.example.cleanarchitecturemovieapp.data.people.PeopleResult

interface ArtistRepository {
    suspend fun getArtists(): List<PeopleResult>?

    suspend fun updateArtists(): List<PeopleResult>?
}