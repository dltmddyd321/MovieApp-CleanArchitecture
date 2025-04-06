package com.example.cleanarchitecturemovieapp.domain.usecase

import com.example.cleanarchitecturemovieapp.data.people.PeopleResult
import com.example.cleanarchitecturemovieapp.domain.repository.ArtistRepository

class GetArtistUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute(): List<PeopleResult>? = artistRepository.getArtists()
}