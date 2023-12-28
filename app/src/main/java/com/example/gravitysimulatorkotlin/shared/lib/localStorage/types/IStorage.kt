package com.example.gravitysimulatorkotlin.shared.lib.localStorage.types

interface IStorage {
    suspend fun set(key: String, value: String)
    suspend fun get(key: String, defaultValue: String): String
}