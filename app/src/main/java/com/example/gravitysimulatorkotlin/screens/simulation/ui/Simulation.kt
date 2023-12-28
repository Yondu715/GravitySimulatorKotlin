package com.example.gravitysimulatorkotlin.screens.simulation.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gravitysimulatorkotlin.widgets.header.ui.Header
import com.example.gravitysimulatorkotlin.widgets.simulation.model.SimulationModel
import com.example.gravitysimulatorkotlin.widgets.simulation.ui.SimulationWidget

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SimulationScreen() {
    val simulationModel: SimulationModel = viewModel()
    Scaffold(
        topBar = {
            Header()
        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SimulationWidget(simulationModel)
            }
        }
    )
}