package com.mp.todocompose.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.mp.todocompose.TodoApplication
import com.mp.todocompose.data.db.TodoEntity
import com.mp.todocompose.data.repository.TodoRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HomeScreenViewModel(
    private val todoRepository: TodoRepository
): ViewModel() {
    val homeUiState: StateFlow<HomeState> =
        todoRepository.getAllTodosStream().map { HomeState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000L),
                initialValue = HomeState()
            )

    fun deleteItem(item: TodoEntity) {
        viewModelScope.launch {
            todoRepository.deleteTodo(item)
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as TodoApplication)
                val repository = application.container.repository
                HomeScreenViewModel(repository)
            }
        }
    }
}
