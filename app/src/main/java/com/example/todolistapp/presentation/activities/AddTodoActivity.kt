package com.example.todolistapp.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.todolistapp.data.models.Todo
import com.example.todolistapp.databinding.ActivityAddTodoBinding
import com.example.todolistapp.presentation.viewModel.TodoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddTodoActivity : AppCompatActivity() {
    private val viewModel: TodoViewModel by viewModels()
    lateinit var binding: ActivityAddTodoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTodoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.todoSaveBtn.setOnClickListener {
            val title = binding.todoTitle.text.toString()
            val description = binding.todoDescription.text.toString()

            viewModel.insertTodo(Todo(0, title, description, false))
        }
    }
}