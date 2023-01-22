package com.example.ak7mtprojekt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.ak7mtprojekt.ui.Overview.OverviewViewModel
import com.example.ak7mtprojekt.ui.Screen
import com.example.ak7mtprojekt.ui.Search.SearchViewModel
import com.example.ak7mtprojekt.ui.WeatherApp
import com.example.ak7mtprojekt.ui.citySearch.CitySearchViewModel
import com.example.ak7mtprojekt.ui.theme.AK7MTProjektTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val citySearchViewModel: CitySearchViewModel by viewModels()
    private val overviewViewModel: OverviewViewModel by viewModels()
    private val searchViewModel: SearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            AK7MTProjektTheme {
                WeatherApp(
                    overviewViewModel,
                    searchViewModel
                )
            }
        }
    }


}

/*@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestComposeScreen(
    name: String,
    citySearchViewModel: CitySearchViewModel
) {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Přehled", "Artists", "Playlists")
    val scope = rememberCoroutineScope()
    Scaffold(

        topBar = {
            TopAppBar(
                title = { Text("Simple Scaffold Screen") },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            scope.launch {  }
                        }
                    ) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Localized description")
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = { Icon(Icons.Filled.Favorite, contentDescription = item) },
                        label = { Text(item) },
                        selected = selectedItem == index,
                        onClick = { selectedItem = index }
                    )
                }
            }
        },
        content = { innerPadding ->
            LazyColumn(contentPadding = innerPadding) {

            }
        }
    )
}*/



/*@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AK7MTProjektTheme {
        Greeting("Android")
    }
}*/