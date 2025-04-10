package com.example.cleanarchitecturemovieapp.presentation.di

import com.example.cleanarchitecturemovieapp.presentation.di.artist.ArtistSubComponent
import com.example.cleanarchitecturemovieapp.presentation.di.movie.MovieSubComponent
import com.example.cleanarchitecturemovieapp.presentation.di.tvShow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
}