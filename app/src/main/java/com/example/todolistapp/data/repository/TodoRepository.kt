package com.example.todolistapp.data.repository

import com.example.todolistapp.data.models.Todo
import com.example.todolist.data.database.dao.TodoDao
import java.util.concurrent.Executors
import javax.inject.Inject

class TodoRepository @Inject constructor(private val todoDao: TodoDao) {
    private val executorService = Executors.newFixedThreadPool(4)

    fun getAllTodo(): List<Todo> {
        return todoDao.getAllTodos()
    }

    fun insertTodo(todo: Todo) {
        executorService.execute {
            todoDao.insertTodo(todo)
        }
    }

    fun updateTodo(todo: Todo) {
        executorService.execute {
            todoDao.updateTodo(todo)
        }
    }

    fun deleteTodo(todo: Todo) {
        executorService.execute {
            todoDao.deleteTodo(todo)
        }
    }
}