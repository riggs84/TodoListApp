package com.example.todolistapp.presentation.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolistapp.presentation.viewModel.TodoViewModel
import com.example.todolistapp.presentation.adapters.TodoRecyclerViewAdapter
import com.example.todolistapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val viewModel: TodoViewModel by viewModels()
    private val adapter = TodoRecyclerViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            recyclerView.layoutManager = LinearLayoutManager(applicationContext)
            recyclerView.adapter = adapter
            floatingActionButton.setOnClickListener {
                val intent = Intent(applicationContext, AddTodoActivity::class.java)
                startActivity(intent)
            }

        }
        viewModel.liveData.observe(this) {
            Log.d("azaza", "observer")
            adapter.updateTodoList(it)
        }
    }
}