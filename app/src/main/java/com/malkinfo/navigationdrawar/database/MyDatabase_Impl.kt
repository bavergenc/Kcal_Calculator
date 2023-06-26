package com.malkinfo.navigationdrawar.database

import android.content.Context
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.Room
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.malkinfo.navigationdrawar.database.dao.Dao

class MyDatabase_Impl private constructor(context: Context) : MyDatabase() {

    private val database: MyDatabase = Room.databaseBuilder(
        context.applicationContext,
        MyDatabase::class.java,
        "results.db"
    ).build()

    override fun dao(): Dao {
        return database.dao()
    }

    override fun createOpenHelper(config: DatabaseConfiguration?): SupportSQLiteOpenHelper {
        TODO("Not yet implemented")
    }

    override fun createInvalidationTracker(): InvalidationTracker {
        TODO("Not yet implemented")
    }

    override fun clearAllTables() {
        TODO("Not yet implemented")
    }

    companion object {
        private var instance: MyDatabase_Impl? = null

        fun getInstance(context: Context): MyDatabase_Impl {
            return instance ?: synchronized(this) {
                instance ?: MyDatabase_Impl(context).also { instance = it }
            }
        }
    }
}