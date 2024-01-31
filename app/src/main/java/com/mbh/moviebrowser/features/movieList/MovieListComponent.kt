package com.mbh.moviebrowser.features.movieList

import com.mbh.moviebrowser.di.BindModule
import dagger.Component

@Component(modules = [BindModule::class])
interface MovieListComponent {
    fun inject(viewModel: MovieListViewModel)
}
