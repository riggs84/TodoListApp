package com.example.todolistapp.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistapp.data.models.Todo
import com.example.todolistapp.R
import com.example.todolistapp.databinding.TodoItemBinding

class TodoRecyclerViewAdapter : RecyclerView.Adapter<TodoRecyclerViewAdapter.TodoViewHolder>() {

    private var todos: List<Todo> = ArrayList()

    class TodoViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = TodoItemBinding.bind(item)
        fun bind(todo: Todo) {
            binding.todoDescription.text = todo.description
            binding.todoTitle.text = todo.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.todo_item,
            parent,
            false
        )
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(todos[position])
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    fun updateTodoList(data: List<Todo>) {
        todos = data
        notifyDataSetChanged()
    }
}