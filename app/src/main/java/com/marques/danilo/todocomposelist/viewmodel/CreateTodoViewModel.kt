package com.marques.danilo.todocomposelist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marques.danilo.todocomposelist.data.Todo
import com.marques.danilo.todocomposelist.data.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CreateTodoViewModel @Inject internal constructor(private val todoRepository: TodoRepository) :
    ViewModel() {
    fun create(title: String): Unit {
        val todo = Todo(title, false)
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                todoRepository.insert(todo)
            }
        }
    }
}