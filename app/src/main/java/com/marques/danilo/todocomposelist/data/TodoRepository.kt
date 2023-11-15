package com.marques.danilo.todocomposelist.data

import javax.inject.Inject

class TodoRepository @Inject internal constructor(private val todoDao: TodoDao) {
    suspend fun insert(todo: Todo) {
        todoDao.insert(todo)
    }

    val list = todoDao.list()

    suspend fun update(todo: Todo) {
        todoDao.delete(todo)
    }
}