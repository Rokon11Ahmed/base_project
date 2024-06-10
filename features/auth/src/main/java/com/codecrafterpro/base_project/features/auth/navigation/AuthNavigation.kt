package com.codecrafterpro.base_project.features.auth.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.codecrafterpro.base_project.features.auth.LoginRoute

const val AUTH_ROUTE = "auth_route"

fun NavController.navigateToAuth(navOptions: NavOptions) = navigate(AUTH_ROUTE, navOptions)

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(startDestination = "login", route = AUTH_ROUTE) {
        composable("login") { LoginRoute() }
        //composable("register") { RegisterScreen(navController) }
    }
}