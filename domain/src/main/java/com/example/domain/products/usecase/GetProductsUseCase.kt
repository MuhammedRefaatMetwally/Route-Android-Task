package com.example.domain.products.usecase

import com.example.domain.common.ResultWrapper
import com.example.domain.products.model.ProductsEntity
import com.example.domain.products.repository.ProductsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val repository: ProductsRepository
) {
    suspend fun invoke(): ProductsEntity {
        return repository.getProducts()
    }


}