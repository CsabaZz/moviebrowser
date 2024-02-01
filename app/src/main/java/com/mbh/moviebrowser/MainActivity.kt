package com.mbh.moviebrowser

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mbh.moviebrowser.features.movieDetails.MovieDetailsScreen
import com.mbh.moviebrowser.features.movieDetails.MovieDetailsViewModel
import com.mbh.moviebrowser.features.movieList.MovieListScreen
import com.mbh.moviebrowser.features.movieList.MovieListViewModel
import com.mbh.moviebrowser.repository.IMoviesRepository
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var moviesRepository: IMoviesRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerMainActivityComponent.factory()
            .create(applicationContext)
            .inject(this)

        setContent {
            MaterialTheme(
                colorScheme = if(isSystemInDarkTheme()) {
                    darkColorScheme(onSurface = Color.White)
                } else {
                    lightColorScheme()
                }
            ) {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "list") {
                    composable("list") {
                        MovieListScreen(
                            viewModel = MovieListViewModel(moviesRepository),
                            onDetailsClicked = {
                                navController.navigate("details")
                            },
                        )
                    }
                    composable("details") {
                        MovieDetailsScreen(
                            viewModel = MovieDetailsViewModel(moviesRepository),
                        )
                    }
                }
            }
        }
    }
}
