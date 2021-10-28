package com.vipulsaluja.hiltlearningdemo.repository.impl

import com.vipulsaluja.hiltlearningdemo.model.Product
import com.vipulsaluja.hiltlearningdemo.network.NetworkApi
import com.vipulsaluja.hiltlearningdemo.repository.ProductRepository
import javax.inject.Inject


/**
 * Created by Vipul Saluja on 26-10-2021.
 */
open class ProductRepositoryImpl @Inject constructor(var networkApi: NetworkApi) : ProductRepository {

    override suspend fun getProducts(): List<Product>? {
        return networkApi.getProducts().body()
    }
}