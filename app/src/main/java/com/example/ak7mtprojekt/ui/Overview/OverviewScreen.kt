package com.example.ak7mtprojekt.ui.Overview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlin.random.Random

@Composable
fun OverviewScreen(
    navController: NavController,
    overviewViewModel: OverviewViewModel
) {
    val cities by overviewViewModel.cities.collectAsState()

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row (
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(Color.Yellow)
                .fillMaxWidth(),
        ){
            Text(
                text = "overview",
                fontSize = 20.sp,
            )
        }
        cities.forEach {
            Row {
                Text(text = it.name)
                Text(text = it.weather)
                Text(text = "${Random.nextInt(1, 30)}°C")
            }
        }
    }
}