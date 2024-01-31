package com.mbh.moviebrowser.di

import com.mbh.moviebrowser.repository.IMoviesRepository
import com.mbh.moviebrowser.repository.MoviesRepository
import dagger.Binds
import dagger.Module

@Module
interface BindModule {

    @Binds
    fun moviesRepository(repository: MoviesRepository): IMoviesRepository
}
