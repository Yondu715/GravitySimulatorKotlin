package com.example.gravitysimulatorkotlin.entities.session.model

object SessionModelFactory {
    private var instance: SessionModel? = null
    fun createInstance(): SessionModel {
        if (instance === null) {
            instance = SessionModel()
        }
        return instance!!
    }
}