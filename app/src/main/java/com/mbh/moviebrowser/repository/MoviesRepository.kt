package com.mbh.moviebrowser.repository

import com.mbh.moviebrowser.domain.Movie
import com.mbh.moviebrowser.features.util.ViewState
import com.mbh.moviebrowser.network.INetworkService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MoviesRepository @Inject constructor(
    val service: INetworkService
): IMoviesRepository {
    private val moviesXIsFavorite: MutableMap<Long,Boolean> = mutableMapOf()

    override val movies: MutableStateFlow<List<Movie>> = MutableStateFlow(emptyList())
    override val detailsId: MutableStateFlow<Long> = MutableStateFlow(-1)

    override suspend fun fetchMovies(): Flow<ViewState<List<Movie>>> =
        flow {
            emit(ViewState.loading<List<Movie>>())
            val movies = service.getTrendingMovies()
                .onEach {
                    it.isFavorite = moviesXIsFavorite[it.id] ?: false
                }
            emit(ViewState.success(movies))
        }.flowOn(Dispatchers.IO)

    override suspend fun changeFavorite(favorite: Boolean) {
        moviesXIsFavorite[detailsId.value] = favorite
        val index = movies.value.indexOfFirst { it.id == detailsId.value }
        movies.value.toMutableList().also {
            it[index] = it[index].copy(isFavorite = favorite)
        }.also {
            movies.emit(it)
        }
    }
}
