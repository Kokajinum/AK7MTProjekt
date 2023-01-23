package com.example.ak7mtprojekt.ui.Search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ak7mtprojekt.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    navController: NavController,
    searchViewModel: SearchViewModel
) {

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val searchText by searchViewModel.searchState.collectAsState()
        TextField(
            value = searchText,
            onValueChange = { searchViewModel.updateSearchQuery(it) },
            placeholder = { Text(stringResource(R.string.search_textfield_placeholder)) },
            modifier = Modifier.padding(16.dp)
        )

        Button(
            onClick = {
                if (searchText != "") {
                    searchViewModel.searchCities()
                }
                      },
            )
        {
            Icon(
                Icons.Filled.Search,
                contentDescription = "Search",
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text(stringResource(id = R.string.search_button))
        }

        val isFavIconVisible by searchViewModel.isFavIconVisible.collectAsState()
        val cities by searchViewModel.cities.collectAsState()
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(cities) { city ->
                Card(
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier.padding(25.dp, 5.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 10.dp),
                    onClick = {  }

                ) {
                    Column(
                        modifier = Modifier
                            .padding(12.dp)
                            .fillMaxWidth()
                    ) {
                        Text("${city.name}", fontWeight = FontWeight.Bold)
                        Row {
                            Text("${city.country}")
                            if (city.state != null) {
                                Text("${city.state}")
                            }

                            /*if (isFavIconVisible) {
                                Icon(
                                    Icons.Filled.Favorite,
                                    contentDescription = "Favorite",
                                    modifier = Modifier.size(ButtonDefaults.IconSize),

                                    )
                            }*/

                        }

                    }
                }
            }
        }
    }
}