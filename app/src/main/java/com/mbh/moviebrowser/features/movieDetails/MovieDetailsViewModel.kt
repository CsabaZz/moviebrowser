package com.mbh.moviebrowser.features.movieDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mbh.moviebrowser.repository.IMoviesRepository
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.lastOrNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MovieDetailsViewModel(
    val moviesRepository: IMoviesRepository,
) : ViewModel() {

    val movie = moviesRepository.movies.map { it.firstOrNull { it.id == moviesRepository.detailsId.value } }

    fun onFavoriteClicked(isFavorite: Boolean) {
        viewModelScope.launch {
            moviesRepository.changeFavorite(isFavorite)
        }
    }
}
