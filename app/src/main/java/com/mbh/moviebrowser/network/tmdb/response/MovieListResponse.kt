package com.mbh.moviebrowser.network.tmdb.response

import com.mbh.moviebrowser.network.tmdb.data.TmdbMovie

data class MovieListResponse(
    val results: List<TmdbMovie>
)
