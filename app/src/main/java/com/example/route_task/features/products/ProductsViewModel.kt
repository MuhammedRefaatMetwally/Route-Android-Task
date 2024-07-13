package com.example.route_task.features.products

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.model.ProductsItem
import com.example.data.model.ProductsResponse
import com.example.domain.products.model.ProductsEntity
import com.example.domain.products.model.ProductsItemEntity
import com.example.domain.products.usecase.GetProductsUseCase
import com.example.route_task.core.utils.ViewError
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException

import java.lang.Exception
import javax.inject.Inject



@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase

) : ViewModel() {
    val shouldShowLoading = MutableLiveData<Boolean>()
    val shouldShowError = MutableLiveData<Boolean>()
    val productsLiveData = MutableLiveData<List<ProductsItemEntity?>?>()
    val errorLiveData = MutableLiveData<ViewError>()

    fun getProducts() {
        viewModelScope.launch {
            shouldShowLoading.postValue(true)
            shouldShowError.postValue(false)
            try {
                val products = getProductsUseCase.invoke()
                productsLiveData.postValue(products.products)
            } catch (e: HttpException) {
                val errorBodyJsonString = e.response()?.errorBody()?.string()
                val response = Gson().fromJson(errorBodyJsonString, ProductsResponse::class.java)
               // response does not have error message
                errorLiveData.postValue(ViewError(
                    message = "Something Went Wrong"
                ) {
                    getProducts()
                })
            } catch (e: Exception) {
                shouldShowError.postValue(true)
                errorLiveData.postValue(
                    ViewError(
                        throwable = e
                    ) {
                        getProducts()
                    }
                )
            } finally {
                shouldShowLoading.postValue(false)
                shouldShowError.postValue(false)
            }

        }
    }

}