package com.malkinfo.navigationdrawar.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.malkinfo.navigationdrawar.database.model.Result

@Dao
interface Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)

    suspend fun insertResult(result: Result)
}