package com.mp.todocompose.data

import android.content.Context
import com.mp.todocompose.data.db.TodoDataBase
import com.mp.todocompose.data.repository.TodoRepository
import com.mp.todocompose.data.repository.TodoRepositoryImpl

/**
 * [AppContainer] for manual DI.
 */
interface AppContainer {
    val repository: TodoRepository
}

class AppDataContainer(
    private val context: Context
): AppContainer {
    override val repository: TodoRepository by lazy {
        TodoRepositoryImpl(TodoDataBase.getDatabase(context = context).todoDao())
    }
}
