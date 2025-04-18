package com.example.cleanarchitecturemovieapp.presentation.di.tvShow

import com.example.cleanarchitecturemovieapp.presentation.activity.TvShowActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): TvShowSubComponent
    }

}