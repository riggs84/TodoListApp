package com.example.todolistapp.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todolistapp.data.models.Todo
import com.example.todolistapp.data.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(private val repository: TodoRepository) : ViewModel() {

    private var mutableLiveData = MutableLiveData<List<Todo>>()
    val liveData: LiveData<List<Todo>> = mutableLiveData

    fun getAllTodos() {
        if (mutableLiveData.value == null || mutableLiveData.value!!.isEmpty()) {
            updateLiveData()
        }
    }

    fun updateTodo(todo: Todo) {
        repository.updateTodo(todo)
        updateLiveData()
    }

    fun insertTodo(todo: Todo) {
        repository.insertTodo(todo)
        updateLiveData()
    }

    fun deleteTodo(todo: Todo) {
        repository.deleteTodo(todo)
        updateLiveData()
    }

    private fun updateLiveData() {
        mutableLiveData.value = repository.getAllTodo()
    }
}