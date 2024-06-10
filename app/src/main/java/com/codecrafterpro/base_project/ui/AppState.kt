package com.codecrafterpro.base_project.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.codecrafterpro.base_project.features.auth.navigation.AUTH_ROUTE
import com.codecrafterpro.base_project.features.auth.navigation.navigateToAuth
import com.codecrafterpro.base_project.navigation.ParentNavigationScreens
import com.codecrafterpro.base_project.navigation.ParentNavigationScreens.AUTH
import com.codecrafterpro.base_project.navigation.ParentNavigationScreens.MAIN
import com.codecrafterpro.base_project.util.Constant.PARENT_MAIN_ROUTE
import kotlinx.coroutines.CoroutineScope

@Composable
fun rememberAppState(
    isUserLoggedIn: Boolean,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController()
):AppState {

    return remember (
        navController,
        coroutineScope
    ) {
        AppState(
            isUserLoggedIn = isUserLoggedIn,
            navController = navController,
            coroutineScope = coroutineScope
        )
    }
}
@Stable
class AppState (
    isUserLoggedIn: Boolean,
    val navController: NavHostController,
    coroutineScope: CoroutineScope
) {

    var isUserLoggedIn: Boolean = isUserLoggedIn

    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination


    val currentTopLevelDestination: ParentNavigationScreens?
        @Composable get() = when (currentDestination?.route) {
            PARENT_MAIN_ROUTE -> MAIN
            AUTH_ROUTE -> AUTH
            else -> null
        }

    fun navigateToTopLevelDestination(parentNavigationScreens: ParentNavigationScreens) {
        val topLevelNavOptions = navOptions {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }

        when (parentNavigationScreens) {
            MAIN -> navController.navigate(PARENT_MAIN_ROUTE)
            AUTH -> navController.navigateToAuth(topLevelNavOptions)
        }
    }
}