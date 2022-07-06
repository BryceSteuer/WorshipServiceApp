package com.example.worshipserviceapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class GetHymnsModalFactory(private val repository: HymnRepository) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GetHymnsModal(repository) as T
    }
}