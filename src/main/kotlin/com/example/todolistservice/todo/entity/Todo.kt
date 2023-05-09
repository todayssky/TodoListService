package com.example.todolistservice.todo.entity

import com.example.todolistservice.todo.dto.NewTodoReq
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class Todo(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,
        val content: String,
        var isChecked: Boolean,
        val createdAt: LocalDateTime
) {
    companion object {
        fun create(newTodoReq: NewTodoReq): Todo = Todo(
                0,
                newTodoReq.content,
                false,
                LocalDateTime.now()
        )
    }
}