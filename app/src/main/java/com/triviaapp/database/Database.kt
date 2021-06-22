package com.triviaapp.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

@androidx.room.Database(entities = [Model::class], version = 5,exportSchema = false)
abstract  class Database :RoomDatabase(){
    abstract fun dao(): Dao

    companion object {

        @Volatile
        private var INSTANCE: Database? = null

        fun getDatabase(context: Context): Database {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    Database::class.java,
                    "trivia_db"
                ).build()
                INSTANCE = instance
                return instance
            }

        }
    }

}