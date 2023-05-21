package com.mp.todocompose.ui.screen.item

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.mp.todocompose.TodoApplication
import com.mp.todocompose.data.db.TodoEntity
import com.mp.todocompose.data.repository.TodoRepository
import kotlinx.coroutines.launch

class DialogViewModel(
    private val todoRepository: TodoRepository
): ViewModel() {
    var textChange = mutableStateOf("")

    fun onTextChange(input: String) {
        textChange.value = input
    }

    fun saveItem() {
        val item =
            TodoEntity(
                id = 0,
                todoText = textChange.value,
                isComplete = false
            )
        viewModelScope.launch {
            todoRepository.insertTodo(item)
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as TodoApplication)
                val repository = application.container.repository
                DialogViewModel(repository)
            }
        }
    }
}
