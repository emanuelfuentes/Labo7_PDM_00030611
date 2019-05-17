package com.emanuel.myapplication.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.emanuel.myapplication.database.entities.GIthubRepo


@Dao
interface GithubRepoDAO {
    @Query(value = "SELECT*FROM repos")
    fun getAll():LiveData<List<GIthubRepo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(repo:GIthubRepo)

    @Query("DELETE FROM repos")
    fun nukeTable()
}