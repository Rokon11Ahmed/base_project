package com.codecrafterpro.base_project.core.domain.di

import com.codecrafterpro.base_project.core.data.repository.EpisodesRepository
import com.codecrafterpro.base_project.core.domain.usecase.GetEpisodesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    fun provideGetEpisodeUseCase(repository: EpisodesRepository): GetEpisodesUseCase {
        return GetEpisodesUseCase(repository)
    }
}