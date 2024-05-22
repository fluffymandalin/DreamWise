package com.example.dreamwise.database

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DreamViewModel(private val dreamDao: DreamDao) : ViewModel() {

    fun insertDreamEntry(dreamEntry: DreamEntry) {
        viewModelScope.launch {
            dreamDao.insertDreamEntry(dreamEntry)
        }
    }
}
