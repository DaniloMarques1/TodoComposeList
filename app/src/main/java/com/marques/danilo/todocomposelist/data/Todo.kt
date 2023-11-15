package com.marques.danilo.todocomposelist.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(
    val title: String,
    var done: Boolean
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}