package com.malkinfo.navigationdrawar.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "results")
data class Result(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val result: Int
)