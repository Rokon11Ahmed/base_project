package com.codecrafterpro.base_project.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.codecrafterpro.base_project.features.auth.navigation.AUTH_ROUTE
import com.codecrafterpro.base_project.features.auth.navigation.authNavGraph
import com.codecrafterpro.base_project.ui.MainScreen
import com.codecrafterpro.base_project.util.Constant.PARENT_MAIN_ROUTE

@Composable
fun AppNavHost(navController: NavHostController, startDestination: String = AUTH_ROUTE) {

    NavHost(navController = navController, startDestination = startDestination){
        authNavGraph(navController = navController)
        composable(PARENT_MAIN_ROUTE) {
            MainScreen()
        }
    }
}