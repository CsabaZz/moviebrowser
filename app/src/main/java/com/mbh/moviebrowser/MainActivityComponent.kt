package com.mbh.moviebrowser

import android.content.Context
import com.mbh.moviebrowser.di.BindModule
import com.mbh.moviebrowser.di.ProvideModule
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        BindModule::class,
        ProvideModule::class
    ]
)
interface MainActivityComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): MainActivityComponent
    }

    fun inject(activity: MainActivity)
}
