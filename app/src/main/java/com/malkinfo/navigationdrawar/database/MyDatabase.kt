package com.malkinfo.navigationdrawar.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.malkinfo.navigationdrawar.database.dao.Dao
import com.malkinfo.navigationdrawar.database.model.Result

@Database(entities = [Result::class], version = 1, exportSchema = false)
abstract class MyDatabase : RoomDatabase() {

    abstract fun dao(): Dao

    companion object {
        private var instance: MyDatabase? = null

        fun getInstance(context: Context): MyDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): MyDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                MyDatabase::class.java,
                "results.db"
            ).build()
        }
    }
}