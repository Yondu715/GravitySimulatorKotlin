package com.example.gravitysimulatorkotlin.entities.particle.model.types

import kotlin.math.sqrt

class Particle(
    x: Double = 0.0,
    y: Double = 0.0,
    vx: Double = 0.0,
    vy: Double = 0.0,
    private var mass: Double = 1.0
) {
    private val position = Vector(x, y)
    private val velocity = Vector(vx, vy)
    private val force = Vector()

    fun getRadius(): Double {
        return sqrt(mass / kotlin.math.PI)
    }

    fun getPosition(): Vector {
        return this.position
    }

    fun getVelocity(): Vector {
        return this.velocity
    }

    fun getForce(): Vector {
        return this.force
    }

    fun addForce(force: Vector) {
        this.force.add(force)
    }

    fun getMass(): Double {
        return this.mass
    }

    fun addPositionNum(x: Double, y: Double) {
        position.x += x
        position.y += y
    }

    fun addPositionVector(position: Vector) {
        this.position.add(position)
    }

    fun addVelocity(velocity: Vector) {
        this.velocity.add(velocity)
    }

    fun addVelocityNum(x: Double, y: Double) {
        velocity.x += x
        velocity.y += y
    }

    fun resetForce() {
        force.x = 0.0
        force.y = 0.0
    }

    fun distanceTo(particle: Particle): Double {
        val dx = position.x - particle.position.x
        val dy = position.y - particle.position.y
        return sqrt(dx * dx + dy * dy)
    }
}