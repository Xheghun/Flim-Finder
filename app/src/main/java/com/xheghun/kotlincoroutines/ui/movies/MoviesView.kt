
package com.xheghun.kotlincoroutines.ui.movies

import com.xheghun.kotlincoroutines.data.model.Movie

/**
 *
 */
interface MoviesView {

  fun showMovies(movies: List<Movie>)

  fun showError(throwable: Throwable)
}