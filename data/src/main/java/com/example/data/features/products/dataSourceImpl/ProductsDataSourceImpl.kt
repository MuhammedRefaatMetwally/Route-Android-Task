package com.example.data.features.products.dataSourceImpl

import com.example.data.api.WebServices
import com.example.data.features.products.dataSourceContract.ProductDataSource
import com.example.data.mappers.products.toEntity
import com.example.data.model.ProductsResponse
import com.example.domain.common.ResultWrapper
import com.example.domain.products.model.ProductsEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductsDataSourceImpl @Inject constructor(
    private val webServices: WebServices,
) : ProductDataSource {
    override suspend fun getProducts(): ProductsEntity {
        return webServices.getProductsList().toEntity()
    }
}