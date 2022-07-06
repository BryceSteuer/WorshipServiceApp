package com.example.worshipserviceapplication

import com.example.worshipserviceapplication.Database.Entity.WorshipService

class HymnRepository(private val db:HymnDatabase) {
    suspend fun insert(items: WorshipService) = db.getHymnDao().insert(items)
    suspend fun delete(items: WorshipService) = db.getHymnDao().delete(items)

    fun getAllItems() = db.getHymnDao().getAllWorshipServices()
}