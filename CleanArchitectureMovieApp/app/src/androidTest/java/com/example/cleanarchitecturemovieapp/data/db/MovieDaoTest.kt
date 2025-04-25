package com.example.cleanarchitecturemovieapp.data.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.cleanarchitecturemovieapp.data.db.dao.MovieDao
import com.example.cleanarchitecturemovieapp.data.movie.MovieResult
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var dao: MovieDao
    private lateinit var database: TMDBDatabase

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            TMDBDatabase::class.java
        ).build()
        dao = database.movieDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun saveMoviesTest() = runBlocking {
        val movies = listOf(
            MovieResult(1, "overview1", "path1", "2024-03-11", "first"),
            MovieResult(2, "overview2", "path2", "2024-03-23", "second"),
            MovieResult(3, "overview3", "path3", "2024-06-09", "third")
        )
        dao.saveMovies(movies)

        val allMovies = dao.getMovies()
        assertEquals(allMovies, movies)
    }

    @Test
    fun deleteMoviesTest() = runBlocking {
        dao.deleteAllMovies()

        val allMovies = dao.getMovies()
        assertEquals(allMovies, emptyList<MovieResult>())
    }
}