package com.example.gravitysimulatorkotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.gravitysimulatorkotlin.app.App
import com.example.gravitysimulatorkotlin.shared.lib.context.ContextRepositoryFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ContextRepositoryFactory.createInstance().setContext(this)
        setContent {
            App()
        }
    }
}