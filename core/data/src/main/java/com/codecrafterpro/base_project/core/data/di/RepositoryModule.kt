package com.codecrafterpro.base_project.core.data.di

import com.codecrafterpro.base_project.core.network.ktor.ApiService
import com.codecrafterpro.base_project.core.data.repository.EpisodesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideEpisodesRepository(apiService: ApiService): EpisodesRepository{
        return EpisodesRepository(apiService)
    }
}