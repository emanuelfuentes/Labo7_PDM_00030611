package com.emanuel.myapplication.database.repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.emanuel.myapplication.database.daos.GithubRepoDAO
import com.emanuel.myapplication.database.entities.GIthubRepo

class GIthubRepository(private val repoDAO: GithubRepoDAO){

    fun getAll():LiveData<List<GIthubRepo>> = repoDAO.getAll()

    fun nuke() = repoDAO.nukeTable()

    @WorkerThread
    suspend fun insert(repo: GIthubRepo) =repoDAO.insert(repo)
}