package com.example.ak7mtprojekt.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.ak7mtprojekt.ui.Overview.OverviewScreen
import com.example.ak7mtprojekt.ui.Overview.OverviewViewModel
import com.example.ak7mtprojekt.ui.Search.SearchScreen
import com.example.ak7mtprojekt.ui.Search.SearchViewModel
import com.example.ak7mtprojekt.ui.citySearch.CitySearchViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherApp(
    overviewViewModel: OverviewViewModel,
    searchViewModel: SearchViewModel
) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    Scaffold(
        bottomBar = {
            NavigationBar {
                listOfScreens.forEach { screen ->
                    NavigationBarItem(
                        icon = { Icon(screen.iconImage, contentDescription = null) },
                        label = { Text(stringResource(screen.resourceId)) },
                        selected = currentDestination?.hierarchy?.any() { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        },
        content = { innerPadding ->
            NavHost(
                navController,
                startDestination = Screen.Overview.route,
                Modifier.padding(innerPadding)
            ) {
                composable(Screen.Overview.route) {
                    OverviewScreen(
                        navController = navController,
                        overviewViewModel = overviewViewModel)
                }
                composable(Screen.Search.route) {
                    SearchScreen(
                        navController = navController,
                        searchViewModel = searchViewModel
                    )
                }
            }

        }
    )
}

