package com.example.numberinterestingfact.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [NumberModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun numberDao(): NumberDao
}