package com.example.gravitysimulatorkotlin.entities.particle.model.types

import kotlin.math.sqrt

class Vector(var x: Double = 0.0, var y: Double = 0.0) {

    fun add(a: Vector): Vector {
        x += a.x
        y += a.y
        return this
    }

    fun sub(a: Vector): Vector {
        x -= a.x
        y -= a.y
        return this
    }

    fun mult(n: Double): Vector {
        x *= n
        y *= n
        return this
    }

    fun div(n: Double): Vector {
        x /= n
        y /= n
        return this
    }

    fun clone(): Vector {
        return Vector(x, y)
    }

    fun getNegative(): Vector {
        return Vector(-x, -y)
    }

    fun getLength(): Double {
        return sqrt(x * x + y * y)
    }
}