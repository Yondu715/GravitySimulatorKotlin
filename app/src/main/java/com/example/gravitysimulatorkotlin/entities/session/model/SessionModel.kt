package com.example.gravitysimulatorkotlin.entities.session.model

import android.util.Log
import com.example.gravitysimulatorkotlin.entities.session.types.AuthData
import com.example.gravitysimulatorkotlin.entities.session.types.AuthErrors
import com.example.gravitysimulatorkotlin.entities.session.types.AuthException
import com.example.gravitysimulatorkotlin.entities.session.types.AuthStatus
import com.example.gravitysimulatorkotlin.entities.session.types.AuthSuccess
import com.example.gravitysimulatorkotlin.shared.api.ApiServiceFactory
import com.example.gravitysimulatorkotlin.shared.lib.localStorage.StorageFactory
import com.example.gravitysimulatorkotlin.shared.lib.localStorage.types.KeyStore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.serialization.json.Json
import kotlin.jvm.Throws

class SessionModel {
    private val _apiService = ApiServiceFactory.createInstance()
    private val _storage = StorageFactory.createInstance()
    private val _authStatus = MutableStateFlow(AuthStatus.Pending)
    val authStatus = _authStatus.asStateFlow()

    @Throws(AuthException::class)
    suspend fun authFx(login: String, password: String) {
        val authData = Json.encodeToString(AuthData.serializer(), AuthData(login, password))
        val response = this._apiService.auth(authData)
        Log.i("INFO", response.body)
        if (response.isSuccessful()) {
            val authSuccess = Json.decodeFromString<AuthSuccess>(response.body)
            this._storage.set(KeyStore.token, authSuccess.data.access_token)
            this._authStatus.value = AuthStatus.Authorized
        } else {
            this._authStatus.value = AuthStatus.Unauthorized
            val authErrors = Json.decodeFromString<AuthErrors>(response.body)
            throw AuthException("Error with Authorization", authErrors)
        }
    }

    fun checkAuthFx() {
        val response = this._apiService.me()
        if (response.isSuccessful()) {
            this._authStatus.value = AuthStatus.Authorized
        } else {
            this._authStatus.value = AuthStatus.Unauthorized
        }
    }
}