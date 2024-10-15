package com.sample.test.presentation.viewmodel.cataloglist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.test.domain.models.ToastEntity
import com.sample.test.domain.usecase.ToastCatalogList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ToastCatalogListViewModel @Inject constructor(
    private val toastCatalogList: ToastCatalogList
): ViewModel() {
    private val _uiState = MutableStateFlow(CatalogListUIState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            Log.d("Anupam", "load Data")
            val result = toastCatalogList()
            updateUiState(
                isLoading = false,
                toastList = result.getOrNull(),
                errorMessage = result.exceptionOrNull()?.message
            )
        }
    }

    private fun updateUiState(
        isLoading: Boolean? = null,
        toastList: List<ToastEntity>? = null,
        errorMessage: String? = null
    ) {
        _uiState.update { uiState ->
            uiState.copy(
                isLoading = isLoading ?: uiState.isLoading,
                toastList = toastList ?: uiState.toastList,
                errorMessage = errorMessage
            )
        }
    }
}