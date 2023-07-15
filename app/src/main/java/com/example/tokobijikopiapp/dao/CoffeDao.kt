package com.example.tokobijikopiapp.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.tokobijikopiapp.model.Coffe
import kotlinx.coroutines.flow.Flow

@Dao
interface CoffeDao {
    @Query("SELECT * FROM coffe_table ORDER BY name ASC")
    fun getAllCoffe(): Flow<List<Coffe>>

    @Insert
    suspend fun insertCoffe(coffe: Coffe)

    @Delete
    suspend fun deleteCoffe(coffe: Coffe)

    @Update fun updateCoffe(coffe: Coffe)
}