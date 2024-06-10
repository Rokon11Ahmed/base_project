package com.codecrafterpro.base_project.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.codecrafterpro.base_project.core.design.component.BottomNavBar
import com.codecrafterpro.base_project.features.articles.navigation.navigateToArticles
import com.codecrafterpro.base_project.features.home.navigation.navigateToHome
import com.codecrafterpro.base_project.features.profile.navigation.navigateToProfile
import com.codecrafterpro.base_project.navigation.BottomNavGraph
import com.codecrafterpro.base_project.navigation.BottomNavigationScreens

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) {
        Box(modifier = Modifier.padding(it)){
            BottomNavGraph(navController)
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val bottomNavigationScreens: List<BottomNavigationScreens> = BottomNavigationScreens.entries
    AppBottomBar(navController = navController, destinations = bottomNavigationScreens)
}

@Composable
fun AppBottomBar(
    modifier: Modifier = Modifier,
    navController: NavController,
    destinations: List<BottomNavigationScreens>
) {
    BottomNavBar(modifier = modifier) {
        destinations.forEach { destination ->
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination
            val selected = currentDestination.isTopLevelDestinationInHierarchy(destination)
            NavigationBarItem(
                selected = selected,
                onClick = {
                    navigateToBottomNavDestination(destination, navController)
                },
                icon = {
                    BadgedBox(badge = {
                        if (destination.badgeCount != null) {
                            Badge {
                                Text(text = destination.badgeCount.toString())
                            }
                        } else if (destination.hasNews) {
                            Badge()
                        }
                    }) {
                        Icon(
                            imageVector = if (selected) {
                                destination.selectedIcon
                            } else {
                                destination.unselectedIcon
                            }, contentDescription = stringResource(
                                id = destination.titleTextId
                            )
                        )
                    }
                },
                label = {
                    Text(text = stringResource(id = destination.iconTextId))
                })
        }
    }
}

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: BottomNavigationScreens) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false

fun navigateToBottomNavDestination(bottomNavigationScreens: BottomNavigationScreens, navController: NavController) {
    val topLevelNavOptions = navOptions {
        popUpTo(navController.graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }

    when (bottomNavigationScreens) {
        BottomNavigationScreens.Home -> navController.navigateToHome(topLevelNavOptions)
        BottomNavigationScreens.ARTICLES -> navController.navigateToArticles(topLevelNavOptions)
        BottomNavigationScreens.PROFILE -> navController.navigateToProfile(topLevelNavOptions)
    }
}