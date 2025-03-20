package com.roxasjearom.designpatterns.behavioral.strategy.problem

import androidx.compose.runtime.Composable

interface FormField {
    val name: String
    val value: String
    fun isValid(): Boolean
}

class UsernameField(override val value: String) : FormField {
    private val usernameRegex = "^[a-zA-Z][a-zA-Z0-9_-]{2,15}$".toRegex()
    override val name = "Username"
    override fun isValid(): Boolean {
        return value.matches(usernameRegex)
    }
}

class PasswordField(override val value: String) : FormField {
    private val passwordRegex =
        "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$".toRegex()
    override val name = "Password"
    override fun isValid(): Boolean {
        return value.matches(passwordRegex)
    }
}

class EmailField(override val value: String) : FormField {
    private val emailRegex =
        "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\$".toRegex()
    override val name = "E-mail"
    override fun isValid(): Boolean {
        return value.matches(emailRegex)
    }
}

@Composable
fun FormScreen() {
    val usernameField = UsernameField("username")
    val passwordField = PasswordField("password")
    val emailField = EmailField("email")

    val isFormValid = usernameField.isValid() && passwordField.isValid() && emailField.isValid()
}
