package com.example.gravitysimulatorkotlin.shared.lib.localStorage

import com.example.gravitysimulatorkotlin.shared.lib.context.ContextRepositoryFactory

object StorageFactory {
    private var instance: Storage? = null

    fun createInstance(): Storage {
        if (instance === null) {
            val context = ContextRepositoryFactory.createInstance().getContext()
            instance = Storage(context!!)
        }
        return instance!!
    }
}