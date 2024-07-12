package com.example.domain.products.repository

import androidx.paging.PagingData
import com.example.domain.common.ResultWrapper
import com.example.domain.products.model.ProductsEntity
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {
    suspend fun getProducts(categoryId: String? = null): Flow<ResultWrapper<List<ProductsEntity?>?>>

    suspend fun getProductsPaging(categoryId: String? = null): Flow<PagingData<ProductsEntity>>
    suspend fun getSpecificProduct(productId:String):Flow<ResultWrapper<ProductsEntity>>
}