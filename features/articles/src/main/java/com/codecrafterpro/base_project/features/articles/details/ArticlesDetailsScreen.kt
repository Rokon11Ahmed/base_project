package com.codecrafterpro.base_project.features.articles.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import com.codecrafterpro.base_project.core.model.character.Character
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.codecrafterpro.base_project.features.articles.CharacterItem
import com.codecrafterpro.base_project.features.articles.navigation.ArticleScreens


@Composable
fun ArticlesDetailsRoute(
    modifier: Modifier = Modifier,
    backStackEntry: NavBackStackEntry,) {
    val viewModel: ArticlesDetailsViewModel = hiltViewModel(backStackEntry)
    ArticlesDetailsScreen(viewModel)
}

@Composable
fun ArticlesDetailsScreen(viewModel: ArticlesDetailsViewModel) {
    val articlesDetailsUiState by viewModel.articlesDetailsState.collectAsState()
    Box(modifier = Modifier.fillMaxSize()) {
        when {
            articlesDetailsUiState.isLoading -> {
                CircularProgressIndicator(
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.Center),
                    color = MaterialTheme.colorScheme.primary,
                )
            }

            articlesDetailsUiState.error.isNotEmpty() -> {}
            else -> {
                articlesDetailsUiState.data?.let {
                    CharacterDetailsScreen(character = it)
                }
            }
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CharacterDetailsScreen(character: Character) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        Image(
            painter = rememberImagePainter(data = character.image),
            contentDescription = "Character Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = character.name,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = "Status: ${character.status}",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Text(
            text = "Location: ${character.location}",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(16.dp)
        )
    }
}