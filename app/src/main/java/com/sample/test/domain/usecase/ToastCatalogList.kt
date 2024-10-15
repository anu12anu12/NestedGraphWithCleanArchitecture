package com.sample.test.domain.usecase
import android.util.Log
import com.sample.test.domain.models.ToastEntity
import com.sample.test.domain.repository.ToastCatalogListRepository
import javax.inject.Inject

class ToastCatalogList @Inject constructor(
    private val toastCatalogListRepository: ToastCatalogListRepository
) {
    suspend operator fun invoke(): Result<List<ToastEntity>> {
        val result = runCatching {
            toastCatalogListRepository.getToastList()
                .getOrThrow().map { dto -> dto.toToastEntity() }
        }
        Log.d("Anupam", "Data Loaded : ${result.exceptionOrNull()?.message}")
        return result.fold(
            onSuccess = { Result.success(it) },
            onFailure = { Result.failure(it) }
        )
    }
}

