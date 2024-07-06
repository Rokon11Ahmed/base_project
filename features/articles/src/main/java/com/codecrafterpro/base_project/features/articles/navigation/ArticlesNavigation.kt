package com.codecrafterpro.base_project.features.articles.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.codecrafterpro.base_project.features.articles.ArticlesRoute
import com.codecrafterpro.base_project.features.articles.details.ArticlesDetailsRoute

const val ARTICLES_ROUTE = "articles_route"

fun NavController.navigateToArticles(navOptions: NavOptions) = navigate(ARTICLES_ROUTE, navOptions)
fun NavGraphBuilder.articlesScreen(navController: NavController,){
    navigation(route = ARTICLES_ROUTE, startDestination = ArticleScreens.Articles.route) {
        composable(ArticleScreens.Articles.route) {
            ArticlesRoute(navController = navController)
        }

        composable(
            route = ArticleScreens.ArticlesDetails.route + "/{articleId}",
            arguments = listOf(navArgument("articleId") { type = NavType.IntType })
        ) { backStackEntry ->
            ArticlesDetailsRoute(backStackEntry = backStackEntry)
        }
    }
}