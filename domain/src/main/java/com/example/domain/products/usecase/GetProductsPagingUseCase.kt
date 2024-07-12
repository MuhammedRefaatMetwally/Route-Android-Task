package com.example.domain.products.usecase

import androidx.paging.PagingData
import com.example.domain.products.model.ProductsEntity
import com.example.domain.products.repository.ProductsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetProductsPagingUseCase @Inject constructor(
    private val repository: ProductsRepository
) {
    suspend fun invoke(categoryId: String? = null): Flow<PagingData<ProductsEntity>> {
        return repository.getProductsPaging(categoryId)
    }


}