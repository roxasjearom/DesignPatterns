package com.roxasjearom.designpatterns.behavioral.strategy.solution

import androidx.compose.runtime.Composable

fun interface FunctionValidator {
    fun isValid(value: String): Boolean
}

val usernameFunctionValidator = FunctionValidator { value ->
    val usernameRegex = "^[a-zA-Z][a-zA-Z0-9_-]{2,15}$".toRegex()
    value.matches(usernameRegex)
}

val passwordFunctionValidator = FunctionValidator { value ->
    val passwordRegex =
        "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$".toRegex()
    value.matches(passwordRegex)
}

val emailFunctionValidator = FunctionValidator { value ->
    val emailRegex =
        "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\$".toRegex()
    value.matches(emailRegex)
}

//Context
class FunctionFormField(val name: String, private val value: String, private val validator: FunctionValidator) {
    fun isValid(): Boolean {
        return validator.isValid(value)
    }
}

//Client
@Composable
fun FunctionFormScreen() {
    val usernameField = FunctionFormField("Username", "username", usernameFunctionValidator)
    val passwordField = FunctionFormField("Password", "password", passwordFunctionValidator)
    val emailField = FunctionFormField("E-mail", "email", emailFunctionValidator)

    val isFormValid = usernameField.isValid() && passwordField.isValid() && emailField.isValid()
}
