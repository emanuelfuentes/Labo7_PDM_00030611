package com.emanuel.myapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.emanuel.myapplication.database.daos.GithubRepoDAO
import com.emanuel.myapplication.database.entities.GIthubRepo


@Database(entities = [GIthubRepo::class], version= 1, exportSchema = false )
public abstract class RommDB:RoomDatabase(){
    abstract fun repoDAO():GithubRepoDAO

    companion object {
        @Volatile
        private var INSTANCE:RommDB?=null

        fun getInstance(context: Context):RommDB{
            val temInstance= INSTANCE
            if(temInstance!=null){
                return temInstance
            }

            synchronized(this){
                val instance=Room
                    .databaseBuilder(context, RommDB::class.java,"Repo_DB")
                    .build()
                INSTANCE=instance
                return instance
            }

        }

    }
}