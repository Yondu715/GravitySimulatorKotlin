package com.example.gravitysimulatorkotlin.widgets.simulation.ui


import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gravitysimulatorkotlin.entities.particle.ui.particleList.ParticleList
import com.example.gravitysimulatorkotlin.widgets.simulation.model.SimulationModel

@Composable
fun SimulationWidget(simulationModel: SimulationModel = viewModel()) {
    val particles = simulationModel.particles.collectAsState()
    val size = LocalContext.current.resources.displayMetrics

    LaunchedEffect(key1 = null) {
        simulationModel.initParticles(size.heightPixels.toDouble(), size.widthPixels.toDouble())
        simulationModel.simulateFx()
    }

    ParticleList(particles = particles.value)
}