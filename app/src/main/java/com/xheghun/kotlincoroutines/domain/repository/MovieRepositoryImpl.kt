package com.xheghun.kotlincoroutines.domain.repository

import com.xheghun.kotlincoroutines.contextProvider.CoroutineContextProvider
import com.xheghun.kotlincoroutines.credentials.API_KEY
import com.xheghun.kotlincoroutines.data.api.MovieApiService
import com.xheghun.kotlincoroutines.data.database.MovieDao
import com.xheghun.kotlincoroutines.data.model.Movie
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

/**
 * Connects to the end entity, and exposes functionality to the user.
 */
class MovieRepositoryImpl(
    private val movieApiService: MovieApiService,
    private val movieDao: MovieDao,
    private val contextProvider: CoroutineContextProvider
) : MovieRepository {

    override suspend fun getMovies(): List<Movie> {

        val savedMovies = movieDao.getSavedMovies()

        val apiMovies = try {
            movieApiService.getMovies(API_KEY).movies
        } catch (e: Exception) {
            null
        }

        return apiMovies ?: savedMovies
    }
}