package com.example.gravitysimulatorkotlin.shared.api

import com.example.gravitysimulatorkotlin.shared.api.types.IApiService

object ApiServiceFactory {
    private var instance: IApiService? = null

    fun createInstance(): IApiService {
        if (instance === null) {
            instance = ApiService()
        }
        return instance!!
    }
}