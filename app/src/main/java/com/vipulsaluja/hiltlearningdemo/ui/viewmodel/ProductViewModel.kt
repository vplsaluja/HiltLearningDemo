package com.vipulsaluja.hiltlearningdemo.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vipulsaluja.hiltlearningdemo.model.Product
import com.vipulsaluja.hiltlearningdemo.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * Created by Vipul Saluja on 26-10-2021.
 */

@HiltViewModel
class ProductViewModel @Inject constructor(
    var productRepo: ProductRepository
) : ViewModel() {

    private val productList: MutableLiveData<List<Product>> = MutableLiveData()

    fun fetchProducts() {
        viewModelScope.launch {
            productList.value = productRepo.getProducts()
        }
    }

    fun getProductLiveData(): MutableLiveData<List<Product>> {
        return productList
    }
}