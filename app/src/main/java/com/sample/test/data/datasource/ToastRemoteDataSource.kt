package com.sample.test.data.datasource

import com.sample.test.data.models.ToastEntityDto
import com.sample.test.infrastructure.network.NetworkClient
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ToastRemoteDataSource @Inject constructor(
    private val networkClient: NetworkClient,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend fun getToastCatalogList(): Result<List<ToastEntityDto>> {
        return withContext(dispatcher) {
            networkClient.getToastList()
        }
    }
}