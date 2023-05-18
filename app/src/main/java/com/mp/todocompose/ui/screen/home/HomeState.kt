package com.mp.todocompose.ui.screen.home

import com.mp.todocompose.data.db.TodoEntity

data class HomeState(
    val todoList: List<TodoEntity> = emptyList(),
    //val isCheck: Boolean = false
)
