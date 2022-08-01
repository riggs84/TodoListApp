package com.example.todolistapp.data.database.dao

import androidx.room.*
import com.example.todolistapp.data.models.Todo

@Dao
interface TodoDao {

    @Query("SELECT * FROM todo")
    fun getAllTodos(): List<Todo>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertTodo(todo: Todo)

    @Update(onConflict = OnConflictStrategy.ABORT)
    fun updateTodo(todo: Todo)

    @Delete
    fun deleteTodo(todo: Todo)
}