package com.roxasjearom.designpatterns.structural.decorator.problem

import android.util.Log
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale
import java.util.UUID

open class Logger {
    open fun log(message: String) {
        Log.d("Logger", message)
    }
}

class DateTimeLogger() : Logger() {
    override fun log(message: String) {
        val currentDateTime = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault())
        val formattedDateTime = currentDateTime.format(formatter)
        Log.d("DateTimeLogger", "$formattedDateTime: $message")
    }
}

class UniqueIdLogger() : Logger() {
    override fun log(message: String) {
        Log.d("UniqueIdLogger", "${UUID.randomUUID()} $message")
    }
}

class ThreadNameLogger() : Logger() {
    override fun log(message: String) {
        Log.d("ThreadNameLogger", "$message on ${Thread.currentThread().name} thread")
    }
}

//What if we want to combine loggers? This will result in class explosion if we need to cover more scenarios.
class UniqueIdWithDateTimeLogger() : Logger() {
    override fun log(message: String) {
        val currentDateTime = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault())
        val formattedDateTime = currentDateTime.format(formatter)
        Log.d("UniqueIdWithDateTimeLogger", "$formattedDateTime: ${UUID.randomUUID()} $message")
    }
}
