package com.sample.test.infrastructure.di

import com.sample.test.data.repository.ToastCatalogListRepositoryImpl
import com.sample.test.domain.repository.ToastCatalogListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseBindingModule {
    @Binds
    abstract fun bindToastCatalogListRepository(
        toastCatalogListRepositoryImpl: ToastCatalogListRepositoryImpl
    ): ToastCatalogListRepository
}
