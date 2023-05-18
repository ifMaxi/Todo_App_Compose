package com.mp.todocompose.data.repository

import com.mp.todocompose.data.db.TodoEntity
import kotlinx.coroutines.flow.Flow

interface TodoRepository {
    fun getAllTodosStream(): Flow<List<TodoEntity>>

    suspend fun insertTodo(todo: TodoEntity)

    suspend fun deleteTodo(todo: TodoEntity)

    suspend fun updateTodo(todo: TodoEntity)
}
