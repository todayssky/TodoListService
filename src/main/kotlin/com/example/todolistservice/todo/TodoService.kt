package com.example.todolistservice.todo

import com.example.todolistservice.todo.dto.NewTodoReq
import com.example.todolistservice.todo.entity.Todo
import com.example.todolistservice.util.unwrap
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class TodoService(
        val todoRepository: TodoRepository
) {
    fun getTodos(): List<Todo> = todoRepository.findAll()
    fun createTodo(newTodoReq: NewTodoReq) {
        Todo.create(newTodoReq)
                .let(todoRepository::save)
    }

    fun checkTodo(todoId: Long): Todo =
        getTodoById(todoId)
                .apply { isChecked = !isChecked }
                .let(todoRepository::save)

    fun getTodoById(todoId: Long): Todo = todoRepository
            .findById(todoId)
            .unwrap()
            ?: throw ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Not Found, Todo를 찾을 수 없습니다. todoId: $todoId"
            )

    fun deleteTodo(todoId: Long) = todoRepository.deleteById(todoId)
}