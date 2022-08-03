package com.example.todolistapp.presentation.interfaces

import com.example.todolistapp.data.models.Todo

interface OnDeleteBtnClickHandler {

    fun onClick(todo: Todo)
}