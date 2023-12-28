package com.example.gravitysimulatorkotlin.shared.routing

import androidx.navigation.NavController

class NavigationRepository {
    private lateinit var nav: NavController

    fun getNavController(): NavController {
        return this.nav;
    }

    fun setNavController(navController: NavController) {
        this.nav = navController
    }
}

object NavigationStoreFactory {
    private var instance: NavigationRepository? = null

    fun createInstance(): NavigationRepository {
        if (instance === null) {
            instance = NavigationRepository()
        }
        return instance!!
    }
}