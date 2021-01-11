package com.pedroalvarez.ejercicio.data.database

import android.app.Application
import androidx.room.Room

class Favpost: Application() {
    companion object {
        lateinit var database: AppDatabase
    }
    override fun onCreate() {
        super.onCreate()
        Favpost.database =  Room.databaseBuilder(this, AppDatabase::class.java, "tasks-db").build()
    }
}