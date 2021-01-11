package com.pedroalvarez.ejercicio.data.database

import androidx.room.*

@Dao
interface FavoriteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavorite(favoritePost: FavoritePost)

    @Delete
    fun deleteFavorite(favoritePost: FavoritePost)

    @Query("SELECT * FROM postfavorite")
    fun getFavoritePost(): MutableList<FavoritePost>
}