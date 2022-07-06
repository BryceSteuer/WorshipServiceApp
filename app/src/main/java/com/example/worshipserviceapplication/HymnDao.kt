package com.example.worshipserviceapplication

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.worshipserviceapplication.Database.Entity.WorshipService

@Dao
interface HymnDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: WorshipService)

    @Delete
    suspend fun delete(item: WorshipService)

    @Query("SELECT * FROM worship_services")
    fun getAllWorshipServices() : LiveData<List<WorshipService>>
}