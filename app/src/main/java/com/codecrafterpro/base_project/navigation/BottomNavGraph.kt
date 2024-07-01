package com.codecrafterpro.base_project.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.codecrafterpro.base_project.features.articles.navigation.articlesScreen
import com.codecrafterpro.base_project.features.home.navigation.HOME_ROUTE
import com.codecrafterpro.base_project.features.home.navigation.homeScreen
import com.codecrafterpro.base_project.features.profile.navigation.profileScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = HOME_ROUTE
    ) {
        homeScreen()
        profileScreen()
        articlesScreen(navController = navController)
    }
}