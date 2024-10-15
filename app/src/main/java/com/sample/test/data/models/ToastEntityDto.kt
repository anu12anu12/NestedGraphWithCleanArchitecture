package com.sample.test.data.models

import com.google.gson.annotations.SerializedName
import com.sample.test.domain.models.ToastEntity
import java.io.Serializable

data class ToastEntityDto(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("currency")
    val currency: String? = null,
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("last_sold")
    val last_sold: String? = null,
    @SerializedName("price")
    val price: String? = null
): Serializable {
    fun toToastEntity(): ToastEntity {
        return ToastEntity(name, id)
    }
}