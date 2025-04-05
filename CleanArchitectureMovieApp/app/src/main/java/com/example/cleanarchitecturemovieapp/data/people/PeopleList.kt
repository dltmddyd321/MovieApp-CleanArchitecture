package com.example.cleanarchitecturemovieapp.data.people

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class PeopleList(
    @SerializedName("page")
    val page: Int,

    @SerializedName("results")
    val results: List<PeopleResult>?,

    @SerializedName("total_pages")
    val totalPages: Int,

    @SerializedName("total_results")
    val totalResults: Int
)

@Entity(tableName = "popular_artist")
data class PeopleResult(

    @PrimaryKey
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("popularity")
    val popularity: Double,

    @SerializedName("profile_path")
    val profilePath: String
)