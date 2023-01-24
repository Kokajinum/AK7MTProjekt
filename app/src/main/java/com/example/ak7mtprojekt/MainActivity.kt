package com.example.ak7mtprojekt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.ak7mtprojekt.ui.Overview.OverviewViewModel
import com.example.ak7mtprojekt.ui.Search.SearchViewModel
import com.example.ak7mtprojekt.ui.WeatherApp
import com.example.ak7mtprojekt.ui.theme.AK7MTProjektTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val overviewViewModel: OverviewViewModel by viewModels()
    private val searchViewModel: SearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                overviewViewModel.isInitializing.value
            }
        }


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