package com.example.gravitysimulatorkotlin.shared.api

import com.example.gravitysimulatorkotlin.shared.api.types.CustomResponse
import com.example.gravitysimulatorkotlin.shared.api.types.IApiService
import com.example.gravitysimulatorkotlin.shared.lib.localStorage.StorageFactory
import com.example.gravitysimulatorkotlin.shared.lib.localStorage.types.KeyStore
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response

class ApiService: IApiService {

    private var _client = OkHttpClient()
    private  val _baseUrl = "http://172.20.10.2:80/api"
    private  val _JSON = "application/json".toMediaTypeOrNull()
    private val _storage = StorageFactory.createInstance()

    init {
        addAuthHeaderInterceptor()
    }

    private fun addAuthHeaderInterceptor() {
        runBlocking {
            val token = _storage.get(KeyStore.token, KeyStore.tokenDefault)
            val interceptor = Interceptor { chain ->
                val original = chain.request()
                val request = original.newBuilder()
                    .header("Authorization", "Bearer $token")
                    .build()
                chain.proceed(request)
            }
            _client = _client.newBuilder().addInterceptor(interceptor).build()
        }

    }


    private fun createRequest (method: String, url: String, body: String? = ""): CustomResponse {
        val requestBuilder: Request.Builder = Request.Builder().url("$_baseUrl/$url")
        val request: Request = if (method === "get") {
            requestBuilder.get().build()
        } else if (method === "post" && body !== null) {
            val requestBody = body.toRequestBody(this._JSON)
            requestBuilder.post(requestBody).build()
        } else {
            requestBuilder.get().build()
        }
        val response: Response = this._client.newCall(request).execute()
        return CustomResponse(statusCode = response.code, body = response.body?.string())
    }

    override fun auth(json: String): CustomResponse {
        return createRequest("post", "auth/login", json)
    }

    override fun me(): CustomResponse {
        return createRequest("get", "auth/me")
    }

}
