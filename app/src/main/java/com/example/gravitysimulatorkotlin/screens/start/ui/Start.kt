package com.example.gravitysimulatorkotlin.screens.start.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gravitysimulatorkotlin.screens.start.model.StartScreenModel

@Composable
fun StartScreen() {
    val startModel: StartScreenModel = viewModel()

    LaunchedEffect(key1 = null) {
        startModel.checkAuth()
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator()
    }
}
