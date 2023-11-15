package com.marques.danilo.todocomposelist.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.marques.danilo.todocomposelist.viewmodel.CreateTodoViewModel
import com.marques.danilo.todocomposelist.viewmodel.FinishTodoViewModel
import com.marques.danilo.todocomposelist.viewmodel.ListViewModel


@Composable
fun HomeRoute(
    createTodoViewModel: CreateTodoViewModel = hiltViewModel(),
    listTodoViewModel: ListViewModel = hiltViewModel(),
    finishTodoViewModel: FinishTodoViewModel = hiltViewModel()
) {
    val todos by listTodoViewModel.todos.observeAsState(initial = emptyList())
    HomeScreen(
        create = { createTodoViewModel.create(it) },
        todos,
        { finishTodoViewModel.finish(it) })
}