package com.example.cleanarchitecturemovieapp.data.movie

data class PopularMovieList(
    val page: Int,
    val results: List<MovieResult>?
)