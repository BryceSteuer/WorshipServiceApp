package com.example.worshipserviceapplication

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.worshipserviceapplication.Database.Entity.WorshipService

@Database(entities = [WorshipService::class], version = 1)
abstract class HymnDatabase : RoomDatabase() {

    abstract fun getHymnDao(): HymnDao

    companion object {
        @Volatile
        private var instance: HymnDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also {
                instance = it
            }

        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, HymnDatabase::class.java, "Hymns.db")
                .build()

    }
}