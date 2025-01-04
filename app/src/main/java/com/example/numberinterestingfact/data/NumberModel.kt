package com.example.numberinterestingfact.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NumberModel(

    @PrimaryKey(autoGenerate = true) val id: Int = 0,

    @ColumnInfo(name = "number")
    val number: String,

    @ColumnInfo(name= "fact")
    val fact: String,

)