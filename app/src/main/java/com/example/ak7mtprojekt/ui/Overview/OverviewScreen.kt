package com.example.ak7mtprojekt.ui.Overview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ak7mtprojekt.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OverviewScreen(
    navController: NavController,
    overviewViewModel: OverviewViewModel
) {
    overviewViewModel.GetWeatherData()
    val cities by overviewViewModel.cities.collectAsState()

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row (
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth(),
        ){
            Text(
                text = stringResource(id = R.string.overview_screen),
                fontSize = 25.sp,
                modifier = Modifier.padding(0.dp,5.dp,0.dp,0.dp)
            )
        }
        /*cities.forEach {
            Row {
                Text(text = it.cityName ?: "")
                Text(text = it.cityState ?: "")
                Text(text = "${it.temperatureC}°C")
            }
        }*/
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(cities) { city ->
                Card(
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier.padding(25.dp, 5.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 4.dp),
                    onClick = {  }

                ) {
                    Column(
                        modifier = Modifier
                            .padding(12.dp)
                            .fillMaxWidth()
                    ) {
                        Text("${city.cityName}", fontWeight = FontWeight.Bold)
                        Row {
                            Text("Stát: ${city.cityState}")
                        }
                        Row {
                            Text("Teplota: ${city.temperatureC}°C")
                        }

                    }
                }
            }
        }
    }
}