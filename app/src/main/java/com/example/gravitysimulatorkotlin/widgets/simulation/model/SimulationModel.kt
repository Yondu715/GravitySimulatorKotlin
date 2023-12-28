package com.example.gravitysimulatorkotlin.widgets.simulation.model

import androidx.lifecycle.ViewModel
import com.example.gravitysimulatorkotlin.entities.particle.model.types.Particle
import com.example.gravitysimulatorkotlin.entities.particle.model.ParticleModel
import com.example.gravitysimulatorkotlin.entities.particle.model.ParticleModelFactory
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.random.Random

class SimulationModel: ViewModel() {
    private val _particleModel: ParticleModel = ParticleModelFactory.createInstance()
    private val _particles: MutableStateFlow<List<Particle>> = MutableStateFlow(this._particleModel.getParticles())
    private var _isSimulating: Boolean = false

    val particles = _particles.asStateFlow()

    fun initParticles(windowHeight: Double, windowWidth: Double) {
        val temp = ArrayList<Particle>()

        repeat(this._particleModel.getParticlesCount()) {
            temp.add(
                Particle(
                    x = getRandomBetween(50.0, windowWidth - 250),
                    y = getRandomBetween(50.0, windowHeight - 250),
                    mass = getRandomBetween(500.0, 1000.0)
                )
            )
        }
        this._particleModel.setAll(temp)
    }

    private fun getRandomBetween(min: Double, max: Double): Double {
        return min + Random.nextDouble() * max
    }

    suspend fun simulateFx() {
        while (true) {
            if (this._isSimulating) {
                return
            }
            this._isSimulating = true
            this._particleModel.simulate()
            this._isSimulating = false
            delay(10)
        }
    }
}