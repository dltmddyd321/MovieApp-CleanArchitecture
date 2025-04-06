package com.example.cleanarchitecturemovieapp.data.repository

import android.util.Log
import com.example.cleanarchitecturemovieapp.data.people.PeopleResult
import com.example.cleanarchitecturemovieapp.data.repository.datasource.artist.ArtistCacheDataSource
import com.example.cleanarchitecturemovieapp.data.repository.datasource.artist.ArtistLocalDataSource
import com.example.cleanarchitecturemovieapp.data.repository.datasource.artist.ArtistRemoteDataSource
import com.example.cleanarchitecturemovieapp.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
): ArtistRepository {
    override suspend fun getArtists(): List<PeopleResult> = getArtistsFromCache()

    override suspend fun updateArtists(): List<PeopleResult> {
        val newListOfArtists = getArtistsFromApi()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newListOfArtists)
        artistCacheDataSource.saveArtistsToCache(newListOfArtists)
        return newListOfArtists
    }

    suspend fun getArtistsFromApi(): List<PeopleResult> {
        var artists: List<PeopleResult> = emptyList()
        try {
            val response = artistRemoteDataSource.getArtists()
            val body = response.body()
            if (response.isSuccessful && body != null) {
                artists = body.results ?: emptyList()
            }
        } catch (e: Exception) {
            Log.e("ArtistRepoImpl", e.localizedMessage ?: "")
        }
        return artists
    }

    suspend fun getArtistsFromDB(): List<PeopleResult> {
        var artists: List<PeopleResult> = emptyList()
        try {
            artists = artistLocalDataSource.getArtistsFromDB()
        } catch (e: Exception) {
            Log.e("ArtistRepoImpl", e.localizedMessage ?: "")
        }
        if (artists.isNotEmpty()) {
            return artists
        } else {
            artists = getArtistsFromApi()
            artistLocalDataSource.saveArtistsToDB(artists)
        }
        return artists
    }

    suspend fun getArtistsFromCache(): List<PeopleResult> {
        var artists: List<PeopleResult> = emptyList()
        try {
            artists = artistCacheDataSource.getArtistsFromCache()
        } catch (e: Exception) {
            Log.e("ArtistRepoImpl", e.localizedMessage ?: "")
        }
        if (artists.isNotEmpty()) {
            return artists
        } else {
            artists = getArtistsFromDB()
            artistCacheDataSource.saveArtistsToCache(artists)
        }
        return artists
    }
}