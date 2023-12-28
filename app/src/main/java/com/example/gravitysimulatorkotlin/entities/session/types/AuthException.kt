package com.example.gravitysimulatorkotlin.entities.session.types

class AuthException(override val message: String, val authErrors: AuthErrors) : Exception() {

    fun getFirstError(): String {
        if (authErrors.errors.login?.isNotEmpty() == true) {
            return authErrors.errors.login.first()
        }
        return authErrors.errors.password?.first() ?: ""
    }

}