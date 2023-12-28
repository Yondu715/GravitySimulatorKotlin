package com.example.gravitysimulatorkotlin.features.particle.changeCount.model

import androidx.lifecycle.ViewModel
import com.example.gravitysimulatorkotlin.entities.particle.model.ParticleModelFactory
import com.example.gravitysimulatorkotlin.shared.routing.NavigationStoreFactory
import com.example.gravitysimulatorkotlin.shared.routing.routes
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ChangeCountModel: ViewModel() {
    private var _count = MutableStateFlow("")
    private val _particleModel = ParticleModelFactory.createInstance()
    private val _navigationStore = NavigationStoreFactory.createInstance()
    val count = _count.asStateFlow()

    fun setCount(count: String) {
        this._count.value = count
    }

    fun onSubmitted() {
        val countNum = if (this._count.value.isNotEmpty()) this._count.value.toInt() else 0
        _particleModel.setCount(countNum)
        _navigationStore.getNavController().navigate(routes.simulation)
    }
}