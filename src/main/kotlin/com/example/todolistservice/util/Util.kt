package com.example.todolistservice.util

import java.util.*

fun uuid(): UUID = UUID.randomUUID()

fun <T> Optional<T>.unwrap(): T? = orElse(null)