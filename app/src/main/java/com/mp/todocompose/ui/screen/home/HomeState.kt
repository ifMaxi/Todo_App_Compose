package com.mp.todocompose.ui.screen.home

import com.mp.todocompose.data.db.TodoEntity

/**
 * Data class containing the state of the main screen [HomeScreen]
 */
data class HomeState(
    val todoList: List<TodoEntity> = emptyList(),
    //val isCheck: Boolean = false
)
