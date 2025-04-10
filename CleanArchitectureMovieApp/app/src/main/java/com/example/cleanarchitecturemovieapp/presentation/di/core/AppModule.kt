package com.example.cleanarchitecturemovieapp.presentation.di.core

import android.content.Context
import com.example.cleanarchitecturemovieapp.presentation.di.artist.ArtistSubComponent
import com.example.cleanarchitecturemovieapp.presentation.di.movie.MovieSubComponent
import com.example.cleanarchitecturemovieapp.presentation.di.tvShow.TvShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class, ArtistSubComponent::class, TvShowSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }
}