
package com.xheghun.kotlincoroutines.data.api

import com.xheghun.kotlincoroutines.data.model.MoviesResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Used to fetch select movies from the Api.
 */
interface MovieApiService {

  @GET("/3/movie/popular")
  suspend fun getMovies(@Query("api_key") apiKey: String): MoviesResponse
}