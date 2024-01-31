package com.mbh.moviebrowser.network.tmdb.response

import com.mbh.moviebrowser.network.tmdb.data.TmdbGenre

data class GenreListResponse(
    val genres: List<TmdbGenre>
)
