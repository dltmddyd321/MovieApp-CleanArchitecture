package com.example.cleanarchitecturemovieapp.data.repository.datasourceimpl.tvshow

import com.example.cleanarchitecturemovieapp.data.repository.datasource.tvshow.TvShowCacheDataSource
import com.example.cleanarchitecturemovieapp.data.tv.TvResult
import java.util.Collections

class TvShowCacheDataSourceImpl: TvShowCacheDataSource {

    private var tvShowList = Collections.synchronizedList(mutableListOf<TvResult>())

    override suspend fun getTvShowsFromCache(): List<TvResult> = tvShowList

    override suspend fun saveTvShowsToCache(tvShows: List<TvResult>) {
        tvShowList.clear()
        tvShowList.addAll(tvShows)
    }
}