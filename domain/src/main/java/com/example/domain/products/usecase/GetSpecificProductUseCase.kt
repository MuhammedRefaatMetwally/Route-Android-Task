package com.example.domain.products.usecase

import com.example.domain.common.ResultWrapper
import com.example.domain.products.model.ProductsEntity
import com.example.domain.products.repository.ProductsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSpecificProductUseCase @Inject constructor(
    private val repo : ProductsRepository
) {
    suspend operator fun invoke(productId:String):Flow<ResultWrapper<ProductsEntity>>{
        return repo.getSpecificProduct(productId)
    }
}