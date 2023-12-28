package com.example.gravitysimulatorkotlin.features.session.login_form.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gravitysimulatorkotlin.features.session.login_form.model.LoginFormModel

@Composable
fun LoginForm(loginFormModel: LoginFormModel = viewModel()) {
    val login = loginFormModel.login.collectAsState()
    val password = loginFormModel.password.collectAsState()
    val error = loginFormModel.error.collectAsState()

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Авторизация",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.padding(20.dp))
        TextField(
            value = login.value,
            onValueChange = {value -> loginFormModel.setLogin(value)},
            placeholder = { Text(text = "Введите логин")}
        )
        Spacer(modifier = Modifier.padding(20.dp))
        TextField(
            value = password.value,
            onValueChange = {value -> loginFormModel.setPassword(value)},
            placeholder = { Text(text = "Введите пароль")}
        )
        Spacer(modifier = Modifier.padding(20.dp))
        Text(
            text = error.value,
            color = Color.Red,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.padding(20.dp))
        TextButton(
            onClick = { loginFormModel.auth() },
            modifier = Modifier
                .background(Color.Blue)
                .width(100.dp),
        ) {
            Text(
                text = "Войти",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }

    }
}