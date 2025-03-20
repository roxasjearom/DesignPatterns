package com.roxasjearom.designpatterns.behavioral.strategy.solution

import androidx.compose.runtime.Composable

typealias LambdaValidator = (String) -> Boolean

val usernameLambdaValidator: LambdaValidator = { value ->
    val usernameRegex = "^[a-zA-Z][a-zA-Z0-9_-]{2,15}$".toRegex()
    value.matches(usernameRegex)
}

val passwordLambdaValidator: LambdaValidator = { value ->
    val passwordRegex =
        "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$".toRegex()
    value.matches(passwordRegex)
}

val emailLambdaValidator: LambdaValidator = { value ->
    val emailRegex =
        "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\$".toRegex()
    value.matches(emailRegex)
}

//Context
class LambdaFormField(val name: String, val value: String, private val validator: LambdaValidator) {
    fun isValid() = validator(value)
}

//Client
@Composable
fun LambdaFormScreen() {
    val usernameField = LambdaFormField("Username", "username", usernameLambdaValidator)
    val passwordField = LambdaFormField("Password", "password", passwordLambdaValidator)
    val emailField = LambdaFormField("E-mail", "email", emailLambdaValidator)

    val isFormValid = usernameField.isValid() && passwordField.isValid() && emailField.isValid()
}
