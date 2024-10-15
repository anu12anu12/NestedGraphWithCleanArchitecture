package com.sample.test.presentation.viewmodel.cataloglist

import com.sample.test.domain.models.ToastEntity

data class CatalogListUIState(
    val isLoading: Boolean = true,
    val toastList: List<ToastEntity> = emptyList(),
    val errorMessage: String? = null
)