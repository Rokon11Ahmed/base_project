package com.codecrafterpro.base_project.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.codecrafterpro.base_project.features.auth.navigation.AUTH_ROUTE
import com.codecrafterpro.base_project.navigation.AppNavHost
import com.codecrafterpro.base_project.util.Constant

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    appState: AppState
) {
    val startDestination = if (appState.isUserLoggedIn) {
        Constant.PARENT_MAIN_ROUTE
    } else {
        AUTH_ROUTE
    }
    AppNavHost(navController = appState.navController, startDestination = startDestination)
}