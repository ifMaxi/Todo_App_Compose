package com.mp.todocompose.data.repository

import com.mp.todocompose.data.db.TodoDao
import com.mp.todocompose.data.db.TodoEntity
import kotlinx.coroutines.flow.Flow

class TodoRepositoryImpl(
    private val todoDao: TodoDao
): TodoRepository {
    override fun getAllTodosStream(): Flow<List<TodoEntity>> = todoDao.getAllTodos()

    override suspend fun insertTodo(todo: TodoEntity) = todoDao.insert(todo)

    override suspend fun deleteTodo(todo: TodoEntity) = todoDao.delete(todo)

    override suspend fun updateTodo(todo: TodoEntity) = todoDao.update(todo)
}
