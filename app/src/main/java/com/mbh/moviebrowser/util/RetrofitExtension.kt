package com.mbh.moviebrowser.util

import okhttp3.logging.HttpLoggingInterceptor

fun HttpLoggingInterceptor.body() = apply {
    level = HttpLoggingInterceptor.Level.BODY
}
