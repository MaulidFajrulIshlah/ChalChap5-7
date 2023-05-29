package com.geminiboy.chalchap5.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [DataFavMovie :: class], version = 1)
abstract class FavDatabase : RoomDatabase() {

    abstract fun favDao() : FavDao
    
}