package com.xheghun.kotlincoroutines.ui.movies

import com.xheghun.kotlincoroutines.domain.repository.MovieRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/**
 * Handles the business logic calls, reacting to UI events.
 */
class MoviesPresenterImpl(private val movieRepository: MovieRepository) : MoviesPresenter,
    CoroutineScope {

    private val coroutineExceptionHandler =
        CoroutineExceptionHandler { coroutineContext, exceptionHandler ->
            exceptionHandler.printStackTrace()
        }

    private val parentJob = SupervisorJob()

    private lateinit var moviesView: MoviesView

    override fun setView(moviesView: MoviesView) {
        this.moviesView = moviesView
    }

    override fun getData() {
        launch {
            delay(500)
            val result = kotlin.runCatching { movieRepository.getMovies() }

            result.onSuccess { movies ->
                moviesView.showMovies(movies)
            }.onFailure { throwable ->
                handleError(throwable)
            }
        }
    }

    override fun stop() {
        parentJob.cancelChildren()
    }

    private fun handleError(throwable: Throwable) {
        moviesView.showError(throwable)
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + parentJob + coroutineExceptionHandler
}