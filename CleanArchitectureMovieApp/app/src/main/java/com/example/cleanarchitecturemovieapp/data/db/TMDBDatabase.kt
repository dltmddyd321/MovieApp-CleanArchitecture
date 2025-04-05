package com.example.cleanarchitecturemovieapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cleanarchitecturemovieapp.data.db.dao.ArtistDao
import com.example.cleanarchitecturemovieapp.data.db.dao.MovieDao
import com.example.cleanarchitecturemovieapp.data.db.dao.TvShowDao
import com.example.cleanarchitecturemovieapp.data.movie.MovieResult
import com.example.cleanarchitecturemovieapp.data.people.PeopleResult
import com.example.cleanarchitecturemovieapp.data.tv.TvResult

@Database(entities = [MovieResult::class, TvResult::class, PeopleResult::class], version = 1, exportSchema = false)
abstract class TMDBDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvDao(): TvShowDao
    abstract fun artistDao(): ArtistDao
}