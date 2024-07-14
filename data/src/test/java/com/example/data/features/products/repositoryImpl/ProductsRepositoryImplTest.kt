package com.example.data.features.products.repositoryImpl

import com.example.data.features.products.dataSourceContract.ProductDataSource
import com.example.data.model.ProductsItem
import com.example.data.model.ProductsResponse
import com.example.domain.products.model.ProductsItemEntity
import com.example.domain.products.repository.ProductsRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ProductsRepositoryImplTest {
      lateinit  var productsRepository  : ProductsRepository
      val productDataSource = mockk<ProductDataSource>()
    @BeforeEach
    fun setUp() {
        productsRepository = ProductsRepositoryImpl(productDataSource)
    }

    @Test
    fun `verify when call products getProducts() it should call products DataSource`() = runTest {
        // Arrange
        val productsList = listOf(
            ProductsItem(),
            ProductsItem(),
            ProductsItem()
        )
        val response = ProductsResponse(products = productsList)
        coEvery { productDataSource.getProducts() } returns response

        // Act
        val result = productsRepository.getProducts()

        // Assert
        coVerify(exactly = 1) { productDataSource.getProducts() }
        assertEquals(3, result.products?.size)
    }

}