package com.example.gravitysimulatorkotlin.shared.lib.localStorage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.gravitysimulatorkotlin.shared.lib.localStorage.types.IStorage
import kotlinx.coroutines.flow.first

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("grav_sim_k")

class Storage(private val context: Context): IStorage {

    override suspend fun set(key: String, value: String) {
        val prefKey = stringPreferencesKey(key)
        context.dataStore.edit {
            preferences -> preferences[prefKey] = value
        }
    }

     override suspend fun get(key: String, defaultValue: String): String {
         val prefKey = stringPreferencesKey(key)
         val preferences = context.dataStore.data.first()
         return preferences[prefKey] ?: defaultValue
    }
}
