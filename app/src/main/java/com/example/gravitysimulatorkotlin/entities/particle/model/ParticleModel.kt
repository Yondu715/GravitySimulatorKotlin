package com.example.gravitysimulatorkotlin.entities.particle.model

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import com.example.gravitysimulatorkotlin.entities.particle.model.types.Particle
import com.example.gravitysimulatorkotlin.entities.particle.model.types.Vector
import kotlin.math.max

class ParticleModel {
    private var _particlesCount = mutableIntStateOf(0)
    private val _G = 0.001
    private val _particles = mutableStateListOf<Particle>()

    fun getParticles(): List<Particle> {
        return _particles
    }
    fun getParticlesCount(): Int {
        return this._particlesCount.intValue
    }

    fun setAll(particles: List<Particle>) {
        _particles.clear()
        _particles.addAll(particles)
    }

    fun setCount(count: Int) {
        this._particlesCount.intValue = count
    }

    private fun getAttractiveForce(mass1: Double, mass2: Double, range: Double): Double {
        return _G * mass1 * mass2 / max(range * range, 0.00001)
    }

    private fun getAttractiveForceVector(a: Particle, b: Particle): Vector {
        val forceVector = a.getPosition().clone()
        forceVector.sub(b.getPosition())
        val dist = a.distanceTo(b)
        val force = this.getAttractiveForce(a.getMass(), b.getMass(), dist)
        forceVector.mult(force)
        return forceVector
    }

    fun simulate() {
        for (i in 0 until this._particles.size - 1) {
            val p0 = this._particles[i]
            for (j in i + 1 until this._particles.size) {
                val p1 = this._particles[j]
                val force = this.getAttractiveForceVector(p0, p1)
                p0.addForce(force.getNegative())
                p1.addForce(force)
            }
        }
        for (particle in this._particles) {
            val force = particle.getForce().clone()
            val acc = force.div(particle.getMass())
            particle.addVelocity(acc)
            particle.addPositionVector(particle.getVelocity())
            particle.resetForce()
        }
        val newParticles = ArrayList<Particle>()
        val forDelete = ArrayList<Particle>()
        for (i in 0 until this._particles.size - 1) {
            val a = this._particles[i]
            if (forDelete.contains(a)) {
                continue
            }
            for (j in i + 1 until this._particles.size) {
                val b = this._particles[j]
                if (forDelete.contains(b)) {
                    continue
                }
                val posA = a.getPosition().clone()
                val posB = b.getPosition().clone()
                val diff = posA.clone().sub(posB)
                if (diff.getLength() < (a.getRadius() + b.getRadius()) / 2) {
                    val mass = a.getMass() + b.getMass()
                    val newParticle = Particle(mass = mass)
                    newParticle.addPositionNum(
                        posB.x + (diff.x * a.getMass()) / newParticle.getMass(),
                        posB.y + (diff.y * a.getMass()) / newParticle.getMass()
                    )
                    newParticle.addVelocityNum(
                        (a.getMass() / newParticle.getMass()) * a.getVelocity().x + (b.getMass() / newParticle.getMass()) * b.getVelocity().x,
                        (a.getMass() / newParticle.getMass()) * a.getVelocity().y + (b.getMass() / newParticle.getMass()) * b.getVelocity().y
                    )
                    newParticles.add(newParticle)
                    forDelete.addAll(listOf(a, b))
                }
            }
        }
        val updateParticles = this._particles.filter { !forDelete.contains(it) } as ArrayList<Particle>
        updateParticles.addAll(newParticles)
        this._particlesCount.intValue = updateParticles.size
        setAll(updateParticles)
    }
}
