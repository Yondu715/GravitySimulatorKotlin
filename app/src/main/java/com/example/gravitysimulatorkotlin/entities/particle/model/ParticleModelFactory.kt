package com.example.gravitysimulatorkotlin.entities.particle.model

object ParticleModelFactory {
    private var instance: ParticleModel? = null
    fun createInstance(): ParticleModel {
        if (instance === null) {
            instance = ParticleModel()
        }
        return instance!!
    }
}