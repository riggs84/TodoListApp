package com.example.todolistapp.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolistapp.presentation.viewModel.TodoViewModel
import com.example.todolistapp.presentation.adapters.TodoRecyclerViewAdapter
import com.example.todolistapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: TodoViewModel
    private val adapter = TodoRecyclerViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            recyclerView.layoutManager = LinearLayoutManager(applicationContext)
            recyclerView.adapter = adapter
        }

        viewModel = ViewModelProvider(this).get(TodoViewModel::class.java)

        viewModel.liveData.observe(this) {
            adapter.updateTodoList(it)
        }
    }
}