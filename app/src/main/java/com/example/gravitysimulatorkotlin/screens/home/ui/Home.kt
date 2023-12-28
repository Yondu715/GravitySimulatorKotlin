package com.example.gravitysimulatorkotlin.screens.home.ui

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
import com.example.gravitysimulatorkotlin.features.particle.changeCount.model.ChangeCountModel
import com.example.gravitysimulatorkotlin.features.particle.changeCount.ui.ChangeCount

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val changeCountModel: ChangeCountModel = viewModel()
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Gravity Simulator") })
        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ChangeCount(changeCountModel)
            }
        }
    )
}