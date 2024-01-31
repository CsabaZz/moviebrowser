package com.mbh.moviebrowser.network.tmdb.data

import com.google.gson.annotations.SerializedName
import com.mbh.moviebrowser.domain.Genre

data class TmdbGenre(

    @SerializedName("id")
    val id: Long,

    @SerializedName("name")
    val name: String,
)

fun TmdbGenre.toGenre(): Genre = Genre(
    id = id,
    title = name
)