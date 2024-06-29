package com.example.dreamwise.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import java.util.Date

@Dao
interface DreamDao {
    @Insert
    suspend fun insertDreamEntry(dreamEntry: DreamEntry)

    @Query("SELECT * FROM dream_entries WHERE date = :date")
    suspend fun getDreamsByDate(date: Date): List<DreamEntry>
    
    @Query("SELECT * FROM dream_entries WHERE date BETWEEN :startDate AND :endDate")
    suspend fun getDreamsByDateRange(startDate: Date, endDate: Date): List<DreamEntry>
}
