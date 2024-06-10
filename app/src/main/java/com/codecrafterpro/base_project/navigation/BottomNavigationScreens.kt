package com.codecrafterpro.base_project.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.codecrafterpro.base_project.features.home.R
import com.codecrafterpro.base_project.features.articles.R as articlesR
import com.codecrafterpro.base_project.features.profile.R as profileR

enum class BottomNavigationScreens(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconTextId: Int,
    val titleTextId: Int,
    val badgeCount: Int? = null,
    val hasNews: Boolean = false
) {
    Home(
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        iconTextId = R.string.feature_home_title,
        titleTextId = R.string.feature_home_title
    ),
    ARTICLES (
        selectedIcon = Icons.Filled.Settings,
        unselectedIcon = Icons.Outlined.Settings,
        iconTextId = articlesR.string.IDS_ARTICLES,
        titleTextId = articlesR.string.IDS_ARTICLES,
        hasNews = true
    ),
    PROFILE (
        selectedIcon = Icons.Filled.Person,
        unselectedIcon = Icons.Outlined.Person,
        iconTextId =profileR.string.IDS_PROFILE,
        titleTextId = profileR.string.IDS_PROFILE,
        badgeCount = 13
    )
}