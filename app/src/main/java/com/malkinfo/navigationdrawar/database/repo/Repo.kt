package com.tanasi.sflix.database.repo

import com.malkinfo.navigationdrawar.database.MyDatabase
import com.malkinfo.navigationdrawar.database.model.Result
import kotlinx.coroutines.launch


class Repo(private val db: MyDatabase) {
    suspend fun addUser(user: Result) = db.dao().insertResult(user)

//    fun getUser() = db.Dao().getAllUserProfiles()

}