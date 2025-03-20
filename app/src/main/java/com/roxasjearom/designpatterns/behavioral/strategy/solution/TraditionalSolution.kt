package com.roxasjearom.designpatterns.behavioral.strategy.solution

import androidx.compose.runtime.Composable

//Strategy
interface TraditionalValidator {
    fun isValid(value: String): Boolean
}

//Concrete strategies
class UsernameValidator : TraditionalValidator {
    private val usernameRegex = "^[a-zA-Z][a-zA-Z0-9_-]{2,15}$".toRegex()
    override fun isValid(value: String): Boolean {
        return value.matches(usernameRegex)
    }
}

class PasswordValidator : TraditionalValidator {
    private val passwordRegex =
        "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$".toRegex()

    override fun isValid(value: String): Boolean {
        return value.matches(passwordRegex)
    }
}

class EmailValidator : TraditionalValidator {
    private val emailRegex =
        "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\$".toRegex()

    override fun isValid(value: String): Boolean {
        return value.matches(emailRegex)
    }
}

//Context
class FormField(val name: String, val value: String, private val validator: TraditionalValidator) {
    fun isValid(): Boolean {
        return validator.isValid(value)
    }
}

//Client
@Composable
fun FormScreen() {
    val usernameField = FormField("Username", "username", UsernameValidator())
    val passwordField = FormField("Password", "password", PasswordValidator())
    val emailField = FormField("E-mail", "email", EmailValidator())

    val isFormValid = usernameField.isValid() && passwordField.isValid() && emailField.isValid()
}
