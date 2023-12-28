package com.example.gravitysimulatorkotlin.features.particle.changeCount.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gravitysimulatorkotlin.features.particle.changeCount.model.ChangeCountModel

@Composable
fun ChangeCount(changeCountModel: ChangeCountModel = viewModel()) {
    val count = changeCountModel.count.collectAsState()
    Text(
        text = "Gravity Simulator",
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    )
    Spacer(modifier = Modifier.height(20.dp))
    OutlinedTextField(
        value = count.value,
        onValueChange = { value -> changeCountModel.setCount(value)},
        label = { Text(text = "Количество точек") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        )
    Button(onClick = {
        changeCountModel.onSubmitted()
    }) {
        Text(text = "Продолжить")
    }
}