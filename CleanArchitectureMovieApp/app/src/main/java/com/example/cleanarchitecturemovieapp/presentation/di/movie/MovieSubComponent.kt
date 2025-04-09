package com.example.cleanarchitecturemovieapp.presentation.di.movie

import com.example.cleanarchitecturemovieapp.presentation.activity.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): MovieSubComponent
    }

}