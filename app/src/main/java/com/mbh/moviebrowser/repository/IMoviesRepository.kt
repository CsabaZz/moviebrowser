package com.mbh.moviebrowser.repository

import com.mbh.moviebrowser.domain.Movie
import com.mbh.moviebrowser.features.util.ViewState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

interface IMoviesRepository {
    val movies: MutableStateFlow<List<Movie>>
    val detailsId: MutableStateFlow<Long>

    suspend fun fetchMovies(): Flow<ViewState<List<Movie>>>
    suspend fun changeFavorite(favorite: Boolean)
}
