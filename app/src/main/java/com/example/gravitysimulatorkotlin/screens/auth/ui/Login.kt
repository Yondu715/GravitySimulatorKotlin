package com.example.gravitysimulatorkotlin.screens.auth.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gravitysimulatorkotlin.features.session.login_form.model.LoginFormModel
import com.example.gravitysimulatorkotlin.features.session.login_form.ui.LoginForm

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginScreen() {
    val loginFormModel: LoginFormModel = viewModel()
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Gravity Simulator") }) }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LoginForm(loginFormModel)
        }
    }
}