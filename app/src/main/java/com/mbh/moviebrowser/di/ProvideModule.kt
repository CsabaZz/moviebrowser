package com.mbh.moviebrowser.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.mbh.moviebrowser.network.INetworkService
import com.mbh.moviebrowser.network.tmdb.TmdbService
import com.mbh.moviebrowser.util.body
import com.mbh.moviebrowser.util.isDebuggable
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ProvideModule {

    @Provides
    fun provideOkHttpClient(context: Context): OkHttpClient = OkHttpClient.Builder()
        .apply {
            if(context.isDebuggable()) {
                addInterceptor(HttpLoggingInterceptor().body())
            }
        }
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder()
        .create()

    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gson: Gson
    ): Retrofit =
        Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("https://google.com")
            .build()

    @Provides
    fun provideINetworkService(retrofit: Retrofit): INetworkService =
        TmdbService(retrofit)
}
