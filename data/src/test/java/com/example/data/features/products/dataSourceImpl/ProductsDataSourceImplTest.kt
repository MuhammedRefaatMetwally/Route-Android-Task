package com.example.data.features.products.dataSourceImpl

import com.example.data.api.WebServices
import com.example.data.features.products.dataSourceContract.ProductDataSource
import com.example.data.model.ProductsItem
import com.example.data.model.ProductsResponse
import com.example.domain.products.model.ProductsEntity
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ProductsDataSourceImplTest {
    lateinit var productDataSource: ProductDataSource
    private val webServices= mockk<WebServices>()
    @BeforeEach
    fun setUp() {
        productDataSource = ProductsDataSourceImpl(webServices)
    }

    @Test
    fun `when call getProducts from data source it should get data from api`() = runTest{
        val productList = listOf(
            ProductsItem(),
            ProductsItem(),
            ProductsItem(),
        )
        val productsResponse  = ProductsResponse(products = productList)
        coEvery { webServices.getProductsList() } returns productsResponse
        val result = productDataSource.getProducts()
        coVerify(exactly = 1) { webServices.getProductsList() }
        assertEquals(3,result.products?.size)
    }
}