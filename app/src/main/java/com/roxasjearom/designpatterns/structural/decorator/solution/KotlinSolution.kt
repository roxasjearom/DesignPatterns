package com.roxasjearom.designpatterns.structural.decorator.solution

import android.util.Log
import java.util.UUID

fun interface Logger {
    fun log(message: String)
}

val consoleLogger = Logger { message ->
    Log.d("ConsoleLogger", message)
}

fun Logger.withDateTime() = Logger { message ->
    val currentDateTime = java.time.LocalDateTime.now()
    val formatter = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
    val formattedDateTime = currentDateTime.format(formatter)
    log("$formattedDateTime: $message")
}

fun Logger.withUniqueId() = Logger { message ->
    log("UUID: ${UUID.randomUUID()} $message")
}

fun Logger.withThreadName() = Logger { message ->
    log("$message on ${Thread.currentThread().name} thread")
}

fun startLogger() {
    val logger = consoleLogger.withDateTime().withUniqueId().withThreadName()
    logger.log("Application started")
}
