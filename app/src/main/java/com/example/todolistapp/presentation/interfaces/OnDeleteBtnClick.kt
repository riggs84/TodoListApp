package com.example.todolistapp.presentation.interfaces

import com.example.todolistapp.data.models.Todo

interface OnDeleteBtnClick {

    fun onClick(todo: Todo)
}