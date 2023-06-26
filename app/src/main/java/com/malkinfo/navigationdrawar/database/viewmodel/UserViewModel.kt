package com.tanasi.sflix.database.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.malkinfo.navigationdrawar.database.model.Result
import com.tanasi.sflix.database.repo.Repo

import kotlinx.coroutines.launch

class UserViewModel(app: Application, private val repository: Repo
) : AndroidViewModel(app) {


    fun addUser(user: Result) =
        viewModelScope.launch {
            repository.addUser(user)
        }

//    fun getUser() = Repository.getUser()
}