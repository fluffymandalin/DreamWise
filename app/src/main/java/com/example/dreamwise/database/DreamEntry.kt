package com.example.dreamwise.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date


@Entity(tableName = "dream_entries")
data class DreamEntry(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val type: String,
    val description: String,
    val date: Date
)
