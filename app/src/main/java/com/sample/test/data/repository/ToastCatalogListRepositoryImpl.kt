package com.sample.test.data.repository

import com.sample.test.data.datasource.ToastRemoteDataSource
import com.sample.test.data.models.ToastEntityDto
import com.sample.test.domain.repository.ToastCatalogListRepository
import javax.inject.Inject

class ToastCatalogListRepositoryImpl @Inject constructor(
        private val remoteDataSource: ToastRemoteDataSource
    ): ToastCatalogListRepository {
    override suspend fun getToastList(): Result<List<ToastEntityDto>> {
        return remoteDataSource.getToastCatalogList()
    }
}