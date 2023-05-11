package com.example.todolistservice.todo

import com.example.todolistservice.todo.dto.NewTodoReq
import com.example.todolistservice.todo.entity.Todo
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/todo")
class TodoController(
        val todoService: TodoService
) {
    @GetMapping
    fun getTodos(): List<Todo> = todoService.getTodos()

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    fun createTodo(
            @RequestBody @Valid newTodoReq: NewTodoReq
    ) = todoService.createTodo(newTodoReq)

    @PutMapping("/{todoId}")
    fun checkDodo(
            @PathVariable todoId: Long
    ): Todo = todoService.checkTodo(todoId)

    @DeleteMapping("/{todoId}")
    @ResponseStatus(HttpStatus.OK)
    fun deleteTodo(
            @PathVariable todoId: Long
    ) = todoService.deleteTodo(todoId)
}