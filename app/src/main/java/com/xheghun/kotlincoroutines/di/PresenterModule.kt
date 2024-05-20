package com.xheghun.kotlincoroutines.di

import com.xheghun.kotlincoroutines.ui.movies.MoviesPresenter
import com.xheghun.kotlincoroutines.ui.movies.MoviesPresenterImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Creates presenters for the app.
 */

fun presenterModule() = module {
    viewModel { MoviesPresenterImpl(get()) }
}