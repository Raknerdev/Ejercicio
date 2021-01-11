package com.pedroalvarez.ejercicio.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FavoritePost::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao
    companion object{
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context?): AppDatabase{
            if(INSTANCE == null){
                INSTANCE = Room.databaseBuilder(
                    context!!.applicationContext,
                    AppDatabase::class.java,"database-name"
                ).build()
            }
            return INSTANCE!!
        }
    }
}