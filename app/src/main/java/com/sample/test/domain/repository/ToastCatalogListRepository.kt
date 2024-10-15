package com.sample.test.domain.repository

import com.sample.test.data.models.ToastEntityDto

interface ToastCatalogListRepository {
    suspend fun getToastList(): Result<List<ToastEntityDto>>
}