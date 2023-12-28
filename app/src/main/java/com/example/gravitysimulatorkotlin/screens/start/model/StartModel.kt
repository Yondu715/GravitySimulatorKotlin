package com.example.gravitysimulatorkotlin.screens.start.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gravitysimulatorkotlin.entities.session.model.SessionModelFactory
import com.example.gravitysimulatorkotlin.entities.session.types.AuthStatus
import com.example.gravitysimulatorkotlin.shared.routing.NavigationStoreFactory
import com.example.gravitysimulatorkotlin.shared.routing.routes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StartScreenModel: ViewModel() {
    private val _sessionModel = SessionModelFactory.createInstance()
    private val _navigationStore = NavigationStoreFactory.createInstance()

    init {
        viewModelScope.launch {
            _sessionModel.authStatus.collect {
                authStatus ->
                if (authStatus == AuthStatus.Authorized) {
                    _navigationStore.getNavController().navigate(routes.home)
                } else if (authStatus == AuthStatus.Unauthorized) {
                    _navigationStore.getNavController().navigate(routes.login)
                }
            }
        }
    }

    fun checkAuth() {
        viewModelScope.launch(Dispatchers.IO) {
            _sessionModel.checkAuthFx()
        }
    }
}