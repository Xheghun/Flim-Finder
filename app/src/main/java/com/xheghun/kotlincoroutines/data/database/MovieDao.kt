
package com.xheghun.kotlincoroutines.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.xheghun.kotlincoroutines.data.model.Movie

/**
 * DAO Used to communicate operations for saving, deleting and editing movies in the database.
 */

@Dao
interface MovieDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun saveMovies(movies: List<Movie>)

  @Query("SELECT * FROM movies")
  fun getSavedMovies(): List<Movie>
}