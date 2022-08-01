package com.example.todolistapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todolist.data.database.dao.TodoDao
import com.example.todolistapp.data.models.Todo

@Database(entities = [Todo::class], version = 1, exportSchema = false)
abstract class TodoDataBase : RoomDatabase() {
    abstract fun todoDao(): TodoDao
}