package com.example.data.api

import com.example.data.model.ProductsResponse
import retrofit2.http.GET

interface WebServices {
    @GET("products")
    suspend fun getProductsList(): ProductsResponse
}