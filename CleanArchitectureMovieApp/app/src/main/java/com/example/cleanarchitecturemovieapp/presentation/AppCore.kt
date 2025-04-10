package com.example.cleanarchitecturemovieapp.presentation

import android.app.Application
import com.example.cleanarchitecturemovieapp.presentation.di.Injector
import com.example.cleanarchitecturemovieapp.presentation.di.artist.ArtistSubComponent
import com.example.cleanarchitecturemovieapp.presentation.di.core.AppComponent
import com.example.cleanarchitecturemovieapp.presentation.di.core.AppModule
import com.example.cleanarchitecturemovieapp.presentation.di.core.DaggerAppComponent
import com.example.cleanarchitecturemovieapp.presentation.di.core.NetworkModule
import com.example.cleanarchitecturemovieapp.presentation.di.core.RemoteDataModule
import com.example.cleanarchitecturemovieapp.presentation.di.movie.MovieSubComponent
import com.example.cleanarchitecturemovieapp.presentation.di.tvShow.TvShowSubComponent
import com.example.cleanarchitecturemovieapp.util.AppConst

class AppCore: Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .networkModule(NetworkModule(AppConst.BASE_URL))
            .remoteDataModule(RemoteDataModule(AppConst.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}