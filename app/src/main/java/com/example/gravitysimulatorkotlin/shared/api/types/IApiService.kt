package com.example.gravitysimulatorkotlin.shared.api.types

import com.example.gravitysimulatorkotlin.shared.api.types.CustomResponse

interface IApiService {
    fun auth(json: String): CustomResponse
    fun me(): CustomResponse
}

