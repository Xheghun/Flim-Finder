
package com.xheghun.kotlincoroutines.data.model

import com.google.gson.annotations.SerializedName
import com.xheghun.kotlincoroutines.data.model.Movie

/**
 * Wrapper for movies response list.
 */
class MoviesResponse(
    @SerializedName("results") val movies: List<Movie>
)