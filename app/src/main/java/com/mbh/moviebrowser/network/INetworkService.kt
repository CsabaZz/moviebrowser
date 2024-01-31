package com.mbh.moviebrowser.network

import com.mbh.moviebrowser.domain.Genre
import com.mbh.moviebrowser.domain.Movie

interface INetworkService {
    suspend fun getGenres(mediaType: String): List<Genre>
    suspend fun getTrendingMovies(): List<Movie>
}
