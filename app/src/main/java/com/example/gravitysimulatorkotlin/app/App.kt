package com.example.gravitysimulatorkotlin.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.gravitysimulatorkotlin.app.providers.RouterProvider
import com.example.gravitysimulatorkotlin.shared.theme.Gravity_simulator_kotlinTheme

@Composable
fun App() {

    Gravity_simulator_kotlinTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            RouterProvider()
        }
    }
}