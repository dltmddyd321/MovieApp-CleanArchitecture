package com.example.cleanarchitecturemovieapp.data.repository.datasourceimpl.artist

import com.example.cleanarchitecturemovieapp.data.people.PeopleResult
import com.example.cleanarchitecturemovieapp.data.repository.datasource.artist.ArtistCacheDataSource
import java.util.Collections

class ArtistCacheDataSourceImpl: ArtistCacheDataSource {

    private var artistList = Collections.synchronizedList(mutableListOf<PeopleResult>())

    override suspend fun getArtistsFromCache(): List<PeopleResult> = artistList

    override suspend fun saveArtistsToCache(artists: List<PeopleResult>) {
        artistList.clear()
        artistList.addAll(artists)
    }
}