package com.example.gravitysimulatorkotlin.features.session.login_form.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gravitysimulatorkotlin.entities.session.model.SessionModelFactory
import com.example.gravitysimulatorkotlin.entities.session.types.AuthException
import com.example.gravitysimulatorkotlin.shared.routing.NavigationStoreFactory
import com.example.gravitysimulatorkotlin.shared.routing.routes
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginFormModel: ViewModel() {
    private val _sessionModel = SessionModelFactory.createInstance()
    private val _navigationStore = NavigationStoreFactory.createInstance()
    private val _login = MutableStateFlow("")
    private val _password = MutableStateFlow("")
    private val _error = MutableStateFlow("")
    val login = _login.asStateFlow()
    val password = _password.asStateFlow()
    val error = _error.asStateFlow()

    fun setLogin(login: String) {
        this._login.value = login
    }

    fun setPassword(password: String) {
        this._password.value = password
    }

    private fun authExceptionHandler() = CoroutineExceptionHandler {
            _, throwable ->
            if (throwable is AuthException) {
                this._login.value = ""
                this._password.value = ""
                this._error.value = throwable.getFirstError()
            } else {
                throw throwable
            }
    }

    fun auth() {
        viewModelScope.launch(Dispatchers.IO + authExceptionHandler()) {
            _error.value = ""
            _sessionModel.authFx(_login.value, _password.value)
            withContext(Dispatchers.Main) {
                _navigationStore.getNavController().navigate(routes.home)
            }
        }
    }
}