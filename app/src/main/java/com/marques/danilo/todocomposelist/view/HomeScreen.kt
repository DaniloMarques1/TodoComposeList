package com.marques.danilo.todocomposelist.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.marques.danilo.todocomposelist.data.Todo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(create: (title: String) -> Unit, todos: List<Todo>, finish: (todo: Todo) -> Unit) {
    val clicked = remember {
        mutableStateOf<Todo?>(null)
    }
    Column {
        var text by remember { mutableStateOf("") }
        TextField(
            value = text,
            onValueChange = { text = it },
            label = {
                Text("Label")
            }
        )

        Button(onClick = {
            create(text)
        }) {
            Text(text = "Adicionar")
        }

        val openDialog = remember {
            mutableStateOf(false)
        }

        LazyColumn {
            items(todos) { todo ->
                Button(onClick = {
                    openDialog.value = true
                    clicked.value = todo
                }) {
                    Text(text = todo.title)
                }
            }
        }

        when {
            openDialog.value -> {
                Dialog({
                    finish(clicked.value!!)
                    openDialog.value = false
                }, { openDialog.value = false })
            }
        }
    }
}

@Composable
fun Dialog(finish: () -> Unit, close: () -> Unit) {
    AlertDialog(
        title = {},
        text = { Text(text = "Deseja finalizar esse todo?") },
        onDismissRequest = { close() },
        dismissButton = {
            TextButton(onClick = { close() }) {
                Text(text = "Nao")
            }
        },
        confirmButton = {
            TextButton(onClick = { finish() }) {
                Text(text = "Sim")
            }
        })
}