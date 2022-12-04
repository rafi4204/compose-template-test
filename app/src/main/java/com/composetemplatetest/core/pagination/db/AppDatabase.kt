package com.composetemplatetest.core.pagination.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.composetemplatetest.core.pagination.model.RemoteKeys
import com.composetemplatetest.core.pagination.model.Resource
import com.composetemplatetest.core.pagination.dao.RemoteKeysDao
import com.composetemplatetest.core.pagination.dao.ResourceDao


@Database(version = 1, entities = [Resource::class, RemoteKeys::class])
abstract class AppDatabase : RoomDatabase() {

    abstract fun getRepoDao(): RemoteKeysDao
    abstract fun getResourceDao(): ResourceDao

    companion object {

        private const val RESOURCE_DB = "resource.db"

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, RESOURCE_DB)
                .build()
    }

}