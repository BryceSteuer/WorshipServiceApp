package com.example.worshipserviceapplication

import androidx.lifecycle.ViewModel
import com.example.worshipserviceapplication.Database.Entity.WorshipService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class GetHymnsModal(private val repository: HymnRepository) : ViewModel() {

    fun insert(items: WorshipService) = GlobalScope.launch {
        repository.insert(items)
    }

    fun delete(items: WorshipService) = GlobalScope.launch {
        repository.delete(items)
    }

    fun getAllHymnItems() = repository.getAllItems()
}