package com.example.cleanarchitecturemovieapp.data.repository.datasourceimpl.artist

import com.example.cleanarchitecturemovieapp.data.db.dao.ArtistDao
import com.example.cleanarchitecturemovieapp.data.db.dao.MovieDao
import com.example.cleanarchitecturemovieapp.data.movie.MovieResult
import com.example.cleanarchitecturemovieapp.data.people.PeopleResult
import com.example.cleanarchitecturemovieapp.data.repository.datasource.artist.ArtistLocalDataSource
import com.example.cleanarchitecturemovieapp.data.repository.datasource.movie.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistDao: ArtistDao) : ArtistLocalDataSource {

    override suspend fun getArtistsFromDB(): List<PeopleResult> {
        return artistDao.getArtist()
    }

    override suspend fun saveArtistsToDB(artists: List<PeopleResult>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtist(artists)
        }

    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtists()
        }
    }
}