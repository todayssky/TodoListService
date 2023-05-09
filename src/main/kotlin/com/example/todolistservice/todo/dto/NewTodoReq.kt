package com.example.todolistservice.todo.dto

import org.hibernate.validator.constraints.Length
import org.jetbrains.annotations.NotNull

data class NewTodoReq(
        @field:NotNull
        @field:Length(max = 20, min = 1)
        val content: String
)
