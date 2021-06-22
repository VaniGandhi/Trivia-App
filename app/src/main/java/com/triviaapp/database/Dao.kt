package com.triviaapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.triviaapp.model.DatabaseModel

@Dao
interface Dao {

    @Insert
    fun insertData(data: Model)

    @Query("Select * FROM Data")
     fun getdata() : List<DatabaseModel>


}