package com.example.cleanarchitecturemovieapp.data.tv

import com.google.gson.annotations.SerializedName

data class TvList(
    @SerializedName("page")
    val page: Int,

    @SerializedName("results")
    val results: List<TvResult>?,

    @SerializedName("total_pages")
    val totalPages: Int,

    @SerializedName("total_results")
    val totalResults: Int
)
