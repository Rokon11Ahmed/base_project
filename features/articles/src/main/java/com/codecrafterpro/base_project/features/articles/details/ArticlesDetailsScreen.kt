package com.codecrafterpro.base_project.features.articles.details

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import com.codecrafterpro.base_project.features.articles.ArticlesScreenViewModel


@Composable
fun ArticlesDetailsRoute(modifier: Modifier = Modifier,
                         backStackEntry: NavBackStackEntry,) {
    val viewModel: ArticlesDetailsViewModel = hiltViewModel()
    ArticlesDetailsScreen(viewModel)
}

@Composable
fun ArticlesDetailsScreen(viewModel: ArticlesDetailsViewModel) {

}