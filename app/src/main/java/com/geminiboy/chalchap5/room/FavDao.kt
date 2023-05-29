package com.geminiboy.chalchap5.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavDao {
    @Insert
    fun insertData(favData: DataFavMovie)

    @Query("SELECT * FROM DataFavMovie")
    fun getDataNote() : List<DataFavMovie>
}