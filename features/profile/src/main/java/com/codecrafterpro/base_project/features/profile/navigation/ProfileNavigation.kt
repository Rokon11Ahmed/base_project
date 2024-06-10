package com.codecrafterpro.base_project.features.profile.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.codecrafterpro.base_project.features.profile.ProfileRoute

const val PROFILE_ROUTE = "profile_route"

fun NavController.navigateToProfile(navOptions: NavOptions) = navigate(PROFILE_ROUTE, navOptions)
fun NavGraphBuilder.profileScreen(){
    composable(PROFILE_ROUTE){
        ProfileRoute()
    }
}