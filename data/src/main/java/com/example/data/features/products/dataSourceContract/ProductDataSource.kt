package com.example.data.features.products.dataSourceContract

import com.example.data.model.ProductsResponse
import com.example.domain.common.ResultWrapper
import com.example.domain.products.model.ProductsEntity
import kotlinx.coroutines.flow.Flow

interface ProductDataSource {
    suspend fun getProducts(): ProductsEntity
}