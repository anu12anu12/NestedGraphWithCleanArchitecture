package com.sample.test.infrastructure.network

import com.sample.test.data.models.ToastEntityDto
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException
import javax.inject.Inject

class NetworkClient @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getToastList(): Result<List<ToastEntityDto>> {
        return executeRequest { apiService.getToastList() }
    }

    private inline fun <reified T> executeRequest(request: () -> T): Result<T> {
        return try {
            val response = request.invoke()
            Result.success(response)
        } catch (e: UnknownHostException) {
            Result.failure(e)
        } catch (e: SocketTimeoutException) {
            Result.failure(e)
        } catch (e: TimeoutException) {
            Result.failure(e)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
