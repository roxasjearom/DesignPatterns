package com.roxasjearom.designpatterns.structural.decorator.solution

import android.util.Log
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale
import java.util.UUID

//Component
interface TraditionalLogger {
    fun log(message: String)
}

//Concrete Component
class ConsoleLogger : TraditionalLogger {
    override fun log(message: String) {
        Log.d("ConsoleLogger", message)
    }
}

//Decorator
abstract class LoggerDecorator(protected val logger: TraditionalLogger) : TraditionalLogger

//Concrete Decorators
class DateTimeLoggerDecorator(logger: TraditionalLogger) : LoggerDecorator(logger) {
    override fun log(message: String) {
        val currentDateTime = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault())
        val formattedDateTime = currentDateTime.format(formatter)
        logger.log("$formattedDateTime: $message")
    }
}

class UniqueIdLoggerDecorator(logger: TraditionalLogger) : LoggerDecorator(logger) {
    override fun log(message: String) {
        logger.log("UUID: ${UUID.randomUUID()} $message")
    }
}

class ThreadNameLoggerDecorator(logger: TraditionalLogger) : LoggerDecorator(logger) {
    override fun log(message: String) {
        logger.log("$message on ${Thread.currentThread().name} thread")
    }
}

fun startTraditionalLogger() {
    val consoleLogger = ThreadNameLoggerDecorator(UniqueIdLoggerDecorator(DateTimeLoggerDecorator(ConsoleLogger())))
    consoleLogger.log("Application started")
}
