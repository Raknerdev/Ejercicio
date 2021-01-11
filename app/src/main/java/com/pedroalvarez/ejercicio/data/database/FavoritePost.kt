package com.pedroalvarez.ejercicio.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "postfavorite")
data class FavoritePost(
    @PrimaryKey val title: String,
    val url: String,
    val urlImg: String
)
