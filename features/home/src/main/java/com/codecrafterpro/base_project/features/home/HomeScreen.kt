package com.codecrafterpro.base_project.features.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun HomeRoute(modifier: Modifier = Modifier) {

    Scaffold(
        content = {
            HomeScreen(modifier = Modifier.padding(it))
        }

    )
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier, viewModel: HomeScreenViewModel = hiltViewModel()) {
    val homeUiState by viewModel.homeState.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        when {
            homeUiState.isLoading -> {
                CircularProgressIndicator(
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.Center),
                    color = MaterialTheme.colorScheme.primary,
                )
            }

            homeUiState.error.isNotEmpty() -> {}
            else -> {
                LazyColumn {
                    items(items = homeUiState.data?.results ?: emptyList()) { item ->
                        Text(
                            text = item.name,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(16.dp).fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}