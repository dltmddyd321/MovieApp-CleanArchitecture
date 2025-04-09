package com.example.cleanarchitecturemovieapp.presentation.di.artist

import com.example.cleanarchitecturemovieapp.presentation.activity.ArtistActivity
import dagger.Subcomponent

@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {
    fun inject(artistActivity: ArtistActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): ArtistSubComponent
    }

}