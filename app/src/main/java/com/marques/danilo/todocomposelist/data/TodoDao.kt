package com.marques.danilo.todocomposelist.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    @Insert
    fun insert(todo: Todo)

    @Query("select * from todo where done = false")
    fun list(): Flow<List<Todo>>

    @Update
    fun delete(todo: Todo)
}