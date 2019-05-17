package com.emanuel.myapplication.database.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.emanuel.myapplication.database.RommDB
import com.emanuel.myapplication.database.entities.GIthubRepo
import com.emanuel.myapplication.database.repositories.GIthubRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GithubRepoVIewModel(app:Application): AndroidViewModel(app){
    private val repository:GIthubRepository

    init {
        val repoDao=RommDB.getInstance(app).repoDAO()
        repository= GIthubRepository(repoDao)
    }

    fun getAll():LiveData<List<GIthubRepo>> = repository.getAll()

    fun insert(repo: GIthubRepo) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(repo)
    }
}