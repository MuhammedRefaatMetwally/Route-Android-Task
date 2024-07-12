package com.example.data.api

import com.example.data.model.BaseResponse
import com.example.domain.products.model.ProductsEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface WebServices {
    @GET("products")
    suspend fun getProductsList(): BaseResponse<ProductsEntity>
}