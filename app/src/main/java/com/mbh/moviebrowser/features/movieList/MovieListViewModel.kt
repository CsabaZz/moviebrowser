package com.mbh.moviebrowser.features.movieList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mbh.moviebrowser.domain.Movie
import com.mbh.moviebrowser.repository.IMoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class MovieListViewModel(
    val moviesRepository: IMoviesRepository,
) : ViewModel() {

    val movies = moviesRepository.movies

    init {
        viewModelScope.launch {
            moviesRepository.fetchMovies()
                .flowOn(Dispatchers.Main)
                .catch {
                    // error handling
                }
                .collect {
                    moviesRepository.movies.emit(it.data.orEmpty())
                }
        }
    }

    fun storeMovieForNavigation(movie: Movie) {
        moviesRepository.detailsId.value = movie.id
    }
}
