package com.example.cleanarchitecturemovieapp.presentation.di

import android.content.Context
import androidx.room.Room
import com.example.cleanarchitecturemovieapp.data.db.TMDBDatabase
import com.example.cleanarchitecturemovieapp.data.db.dao.ArtistDao
import com.example.cleanarchitecturemovieapp.data.db.dao.MovieDao
import com.example.cleanarchitecturemovieapp.data.db.dao.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideMovieDataBase(context: Context): TMDBDatabase {
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "TMDB").build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MovieDao {
        return tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase): ArtistDao {
        return tmdbDatabase.artistDao()
    }

    @Singleton
    @Provides
    fun provideTvShowDao(tmdbDatabase: TMDBDatabase): TvShowDao {
        return tmdbDatabase.tvDao()
    }
}