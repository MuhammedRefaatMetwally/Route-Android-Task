package com.example.route_task.features.products

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.domain.products.model.ProductsEntity
import com.example.domain.products.model.ProductsItemEntity
import com.example.domain.products.usecase.GetProductsUseCase
import com.example.route_task.utils.getOrAwaitValueTest
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class ProductsViewModelTest {
    //test rule that swaps background executor to a one which executes synchronously(viewModelScope)
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()
    private lateinit var viewModel: ProductsViewModel
    private val getProductsUseCase = mockk<GetProductsUseCase>()

    @Before
    fun setUp() {
        viewModel = ProductsViewModel(getProductsUseCase)
    }

    @Test
    fun `when call getProducts it should get the data`() {
        // Arrange
        val productsResponse = ProductsEntity(
            products = listOf(
                ProductsItemEntity(),
                ProductsItemEntity(),
                ProductsItemEntity(),
            )
        )
        coEvery { getProductsUseCase.invoke() } returns productsResponse
        // Act
        viewModel.getProducts()
        // Assert
        coVerify { getProductsUseCase.invoke() }
        val productsData = viewModel.productsLiveData.getOrAwaitValueTest()
        assertEquals(3,productsData?.size)
    }

    @Test
    fun `when call getProducts it should emit loading state`() {
        // Arrange
        val productsResponse = ProductsEntity()
        coEvery { getProductsUseCase.invoke() } returns productsResponse
        // Act
        viewModel.getProducts()
        // Assert
        val loadingTrueState = viewModel.shouldShowLoading.getOrAwaitValueTest()
        assertTrue(loadingTrueState)
        coVerify { getProductsUseCase.invoke() }
        val loadingFalseState = viewModel.shouldShowLoading.getOrAwaitValueTest()
        assertFalse(loadingFalseState)
    }

}