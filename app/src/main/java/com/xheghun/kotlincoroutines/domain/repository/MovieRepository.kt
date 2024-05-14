package com.xheghun.kotlincoroutines.domain.repository

import com.xheghun.kotlincoroutines.data.model.Movie

/**
 * Interface used to communicate to the end entities, when fetching data.
 */
interface MovieRepository {
    suspend fun getMovies(): List<Movie>
}