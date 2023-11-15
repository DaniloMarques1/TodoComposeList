package com.marques.danilo.todocomposelist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.marques.danilo.todocomposelist.data.Todo
import com.marques.danilo.todocomposelist.data.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val todoRepository: TodoRepository) : ViewModel() {
    val todos: LiveData<List<Todo>> = todoRepository.list.asLiveData()
}