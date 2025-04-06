package com.example.cleanarchitecturemovieapp.data.repository.respositoryimpl

import android.util.Log
import com.example.cleanarchitecturemovieapp.data.repository.datasource.tvshow.TvShowCacheDataSource
import com.example.cleanarchitecturemovieapp.data.repository.datasource.tvshow.TvShowLocalDataSource
import com.example.cleanarchitecturemovieapp.data.repository.datasource.tvshow.TvShowRemoteDataSource
import com.example.cleanarchitecturemovieapp.data.tv.TvResult
import com.example.cleanarchitecturemovieapp.domain.repository.TvShowsRepository

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
): TvShowsRepository {
    override suspend fun getTvShows(): List<TvResult> = getTvShowsFromCache()

    override suspend fun updateTvShows(): List<TvResult> {
        val newListOfTvShows = getTvShowsFromApi()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDB(newListOfTvShows)
        tvShowCacheDataSource.saveTvShowsToCache(newListOfTvShows)
        return newListOfTvShows
    }

    suspend fun getTvShowsFromApi(): List<TvResult> {
        var tvShowList: List<TvResult> = emptyList()
        try {
            val response = tvShowRemoteDataSource.getTvShows()
            val body = response.body()
            if (response.isSuccessful && body != null) {
                tvShowList = body.results ?: emptyList()
            }
        } catch (e: Exception) {
            Log.e("TvShowsRepoImpl", e.localizedMessage ?: "")
        }
        return tvShowList
    }

    suspend fun getTvShowsFromDB(): List<TvResult> {
        var tvShowList: List<TvResult> = emptyList()
        try {
            tvShowList = tvShowLocalDataSource.getTvShowsFromDB()
        } catch (e: Exception) {
            Log.e("TvShowsRepoImpl", e.localizedMessage ?: "")
        }
        if (tvShowList.isNotEmpty()) {
            return tvShowList
        } else {
            tvShowList = getTvShowsFromApi()
            tvShowLocalDataSource.saveTvShowsToDB(tvShowList)
        }
        return tvShowList
    }

    suspend fun getTvShowsFromCache(): List<TvResult> {
        var tvShowList: List<TvResult> = emptyList()
        try {
            tvShowList = tvShowCacheDataSource.getTvShowsFromCache()
        } catch (e: Exception) {
            Log.e("TvShowsRepoImpl", e.localizedMessage ?: "")
        }
        if (tvShowList.isNotEmpty()) {
            return tvShowList
        } else {
            tvShowList = getTvShowsFromDB()
            tvShowCacheDataSource.saveTvShowsToCache(tvShowList)
        }
        return tvShowList
    }
}