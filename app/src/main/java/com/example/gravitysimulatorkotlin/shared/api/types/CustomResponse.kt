package com.example.gravitysimulatorkotlin.shared.api.types

class CustomResponse(statusCode: Int?, body: String?) {
    private val status: Map<Int, Int> = mapOf(
        200 to 200,
        204 to 204,
        400 to 400,
        401 to 401,
        404 to 404
    )

    var statusCode: Int
    var body: String

    init {
        this.statusCode = this.status[statusCode] ?: 404
        this.body = body ?: ""
    }

    fun isSuccessful(): Boolean {
        return statusCode in 200..299
    }
}