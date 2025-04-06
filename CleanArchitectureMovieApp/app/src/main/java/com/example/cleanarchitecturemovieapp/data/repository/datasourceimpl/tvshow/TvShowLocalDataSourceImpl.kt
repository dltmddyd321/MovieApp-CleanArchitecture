package com.example.cleanarchitecturemovieapp.data.repository.datasourceimpl.tvshow

import com.example.cleanarchitecturemovieapp.data.db.dao.TvShowDao
import com.example.cleanarchitecturemovieapp.data.repository.datasource.tvshow.TvShowLocalDataSource
import com.example.cleanarchitecturemovieapp.data.tv.TvResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvShowDao: TvShowDao): TvShowLocalDataSource {
    override suspend fun getTvShowsFromDB(): List<TvResult> =
        tvShowDao.getTvShow()

    override suspend fun saveTvShowsToDB(tvShows: List<TvResult>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTbShow(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvShows()
        }
    }
}