package com.sample.test.infrastructure.network

import com.sample.test.data.models.ToastEntityDto
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("sumup-challenges/mobile-coding-challenge-data/items/")
    suspend fun getToastList(): List<ToastEntityDto>
}