package com.example.gravitysimulatorkotlin.entities.particle.ui.particleList

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import com.example.gravitysimulatorkotlin.entities.particle.model.types.Particle

@Composable
fun ParticleList(particleColor: Color = Color.Black, particles: List<Particle>) {
    Canvas(modifier = Modifier.fillMaxSize(), onDraw = {
        particles.map {
            particle -> drawCircle(
                color = particleColor,
                radius = particle.getRadius().toFloat(),
                center = Offset(x = particle.getPosition().x.toFloat(), y = particle.getPosition().y.toFloat())
            )
        }
    })
}