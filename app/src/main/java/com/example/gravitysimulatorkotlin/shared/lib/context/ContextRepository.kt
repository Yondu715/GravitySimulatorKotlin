package com.example.gravitysimulatorkotlin.shared.lib.context

import android.content.Context

class ContextRepository {

    private var context: Context? = null

    fun setContext(context: Context) {
        this.context = context
    }

    fun getContext(): Context? {
        return this.context
    }
}

object ContextRepositoryFactory {
    private var instance: ContextRepository? = null

    fun createInstance(): ContextRepository {
        if (instance === null) {
            instance = ContextRepository()
        }
        return instance!!
    }
}