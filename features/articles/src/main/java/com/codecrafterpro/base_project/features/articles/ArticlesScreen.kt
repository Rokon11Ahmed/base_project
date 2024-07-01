package com.codecrafterpro.base_project.features.articles

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.codecrafterpro.base_project.core.model.character.Character
import com.codecrafterpro.base_project.features.articles.navigation.ArticleScreens

@Composable
fun ArticlesRoute(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    ArticlesScreen(
        navController = navController
    )
}

@Composable
fun ArticlesScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: ArticlesScreenViewModel = hiltViewModel()
) {
    val articlesUiState by viewModel.articlesState.collectAsState()
    Box(modifier = Modifier.fillMaxSize()) {
        when {
            articlesUiState.isLoading -> {
                CircularProgressIndicator(
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.Center),
                    color = MaterialTheme.colorScheme.primary,
                )
            }

            articlesUiState.error.isNotEmpty() -> {}
            else -> {
                LazyColumn {
                    items(items = articlesUiState.data?.results ?: emptyList()) { item ->
                        CharacterItem(character = item) {atricleId ->
                            val route = ArticleScreens.ArticlesDetails.route+"/$atricleId"
                            navController.navigate(route)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CharacterItem(character: Character, onClick: (Int) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable{
                onClick(character.id)
            }
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = rememberImagePainter(character.image),
                contentDescription = character.name,
                modifier = Modifier
                    .size(64.dp)
                    .align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Text(
                    text = character.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Status: ${character.status}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Location: ${character.location}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

