package com.mp.todocompose.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * App database
 *
 * Main access point to the persisted data.
 * Use the Singleton pattern as only a single instance of the database is required.
 */
@Database(entities = [TodoEntity::class], version = 1, exportSchema = false)
abstract class TodoDataBase: RoomDatabase() {
    abstract fun todoDao(): TodoDao

    companion object {
        @Volatile
        private var Instance: TodoDataBase? = null

        fun getDatabase(context: Context): TodoDataBase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, TodoDataBase::class.java, "todo_database")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}
