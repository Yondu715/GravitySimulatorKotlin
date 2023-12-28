package com.example.gravitysimulatorkotlin.app.providers

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gravitysimulatorkotlin.screens.auth.ui.LoginScreen
import com.example.gravitysimulatorkotlin.screens.home.ui.HomeScreen
import com.example.gravitysimulatorkotlin.screens.simulation.ui.SimulationScreen
import com.example.gravitysimulatorkotlin.screens.start.ui.StartScreen
import com.example.gravitysimulatorkotlin.shared.routing.NavigationStoreFactory
import com.example.gravitysimulatorkotlin.shared.routing.routes

@Composable
fun RouterProvider() {
    val navController = rememberNavController()
    val navigationStore = NavigationStoreFactory.createInstance()
    navigationStore.setNavController(navController)
    NavHost(navController = navController, startDestination = routes.start ) {
        composable(routes.home) {
            HomeScreen()
        }
        composable(routes.simulation) {
            SimulationScreen()
        }
        composable(routes.login) {
            LoginScreen()
        }
        composable(routes.start) {
            StartScreen()
        }
    }
}