package com.example.msasample.presentation.di

import com.example.msasample.data.api.ApiService
import com.example.msasample.data.repository.GetItemRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object PresentationModule {

    @Provides
    fun provideRepository(apiService: ApiService): GetItemRepository = GetItemRepository(apiService)
}