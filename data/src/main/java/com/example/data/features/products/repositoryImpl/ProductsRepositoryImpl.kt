package com.example.data.features.products.repositoryImpl

import com.example.data.features.products.dataSourceContract.ProductDataSource
import com.example.data.mappers.products.toEntity
import com.example.data.model.ProductsResponse
import com.example.domain.common.ResultWrapper
import com.example.domain.products.model.ProductsEntity
import com.example.domain.products.repository.ProductsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private  val dataSource: ProductDataSource,
) : ProductsRepository {
    override suspend fun getProducts(): ProductsEntity {
        return dataSource.getProducts().toEntity()
    }
}