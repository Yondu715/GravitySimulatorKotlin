package com.example.gravitysimulatorkotlin.widgets.header.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.example.gravitysimulatorkotlin.shared.routing.NavigationStoreFactory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header() {
    val navigationStore = NavigationStoreFactory.createInstance()
    val navController = navigationStore.getNavController()
    TopAppBar(
        title = { Text(text = "Gravity Simulator") },
        navigationIcon = {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(Icons.Rounded.ArrowBack, contentDescription = "Вернуться назад")
            }
        }
    )
}