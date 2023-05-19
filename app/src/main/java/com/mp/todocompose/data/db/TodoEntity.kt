package com.mp.todocompose.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Room database.
 *
 * Data class that functions as an entity table.
 * Describes the columns that will be used for this app.
 */
@Entity(tableName = "todo")
data class TodoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val todoText: String,
    val isComplete: Boolean
)
