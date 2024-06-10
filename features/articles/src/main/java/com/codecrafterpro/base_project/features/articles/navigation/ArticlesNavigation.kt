package com.codecrafterpro.base_project.features.articles.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.codecrafterpro.base_project.features.articles.ArticlesRoute

const val ARTICLES_ROUTE = "articles_route"

fun NavController.navigateToArticles(navOptions: NavOptions) = navigate(ARTICLES_ROUTE, navOptions)
fun NavGraphBuilder.articlesScreen(){
    composable(ARTICLES_ROUTE){
        ArticlesRoute()
    }
}