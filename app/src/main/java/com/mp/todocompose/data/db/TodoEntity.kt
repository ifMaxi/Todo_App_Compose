package com.mp.todocompose.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo")
data class TodoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val todoText: String,
    val isComplete: Boolean
)
