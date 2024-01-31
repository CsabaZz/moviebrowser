package com.mbh.moviebrowser.network.tmdb

import androidx.compose.ui.text.intl.Locale
import com.mbh.moviebrowser.domain.Genre
import com.mbh.moviebrowser.domain.Movie
import com.mbh.moviebrowser.network.INetworkService
import com.mbh.moviebrowser.network.tmdb.data.TmdbConstants
import com.mbh.moviebrowser.network.tmdb.data.toGenre
import com.mbh.moviebrowser.network.tmdb.data.toMovie
import retrofit2.Retrofit
import javax.inject.Inject

class TmdbService @Inject constructor(
    private val retrofit: Retrofit
): INetworkService {

    private val language: String by lazy { Locale.current.let { "${it.language}-${it.region}" } }

    private val cachedGenres = HashMap<String,List<Genre>>()

    private val tmdbApi: TmdbApi by lazy {
        retrofit.newBuilder()
            .baseUrl(TmdbConstants.BASE_URL)
            .build()
            .create(TmdbApi::class.java)
    }

    override suspend fun getGenres(mediaType: String): List<Genre> =
        cachedGenres.getOrPut(mediaType) {
            tmdbApi.getGenres(TmdbConstants.AUTH, mediaType, language).genres.map {
                it.toGenre()
            }
        }

    override suspend fun getTrendingMovies(): List<Movie> =
        tmdbApi.getTrendingMovies(TmdbConstants.AUTH, language).results.map { tmdbMovie ->
            tmdbMovie.toMovie().also { movie ->
                movie.genres = getGenres(tmdbMovie.mediaType)
                    .filter { tmdbMovie.genreIds.contains(it.id) }
                    .joinToString(", ") { it.title.lowercase() }
            }
        }
}
