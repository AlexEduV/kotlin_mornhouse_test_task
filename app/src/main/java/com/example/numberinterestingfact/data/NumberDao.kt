package com.example.numberinterestingfact.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NumberDao {

    @Query("Select * From numbermodel")
    suspend fun getAll() : List<NumberModel>

    @Query("SELECT * FROM numbermodel WHERE id IN (:ids)")
    fun loadAllByIds(ids: IntArray): List<NumberModel>

    @Insert
    suspend fun insertAll(vararg numbers: NumberModel)

    @Delete
    fun delete(user: NumberModel)

}