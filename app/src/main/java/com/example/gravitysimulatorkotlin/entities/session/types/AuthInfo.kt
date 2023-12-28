package com.example.gravitysimulatorkotlin.entities.session.types

import kotlinx.serialization.Serializable

@Serializable
data class AuthData(val login: String, val password: String)

@Serializable
data class Errors(val login: ArrayList<String>? = null, val password: ArrayList<String>? = null)

@Serializable
data class Token(val access_token: String, val token_type: String, val expires_in: Int)

@Serializable
data class AuthSuccess(val data: Token)

@Serializable
data class AuthErrors(val errors: Errors)

