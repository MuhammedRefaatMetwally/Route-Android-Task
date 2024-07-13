package com.example.domain.products.repository

import androidx.paging.PagingData
import com.example.domain.common.ResultWrapper
import com.example.domain.products.model.ProductsEntity
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {
    suspend fun getProducts(): ProductsEntity
}