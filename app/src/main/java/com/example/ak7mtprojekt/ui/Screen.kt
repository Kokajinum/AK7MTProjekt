package com.example.ak7mtprojekt.ui

import android.graphics.drawable.Icon
import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.ak7mtprojekt.R

sealed class Screen(val route: String, @StringRes val resourceId: Int, val iconImage: ImageVector){
    object Overview : Screen("overview", R.string.overview_screen, Icons.Filled.Home)
    object Search : Screen("search", R.string.search_screen, Icons.Filled.Search)
}

val listOfScreens = listOf(
    Screen.Overview,
    Screen.Search
)