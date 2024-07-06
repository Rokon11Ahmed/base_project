package com.codecrafterpro.base_project.features.articles.navigation

private object Route {
    const val ARTICLES = "articles"
    const val ARTICLES_DETAILS = "articles_details"
}
sealed class ArticleScreens(val route: String){
    data object Articles: ArticleScreens(Route.ARTICLES)
    data object ArticlesDetails: ArticleScreens(Route.ARTICLES_DETAILS)
}