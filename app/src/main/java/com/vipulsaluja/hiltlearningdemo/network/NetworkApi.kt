package com.vipulsaluja.hiltlearningdemo.network

import com.vipulsaluja.hiltlearningdemo.model.Product
import retrofit2.Response
import retrofit2.http.GET
import rx.Observable


/**
 * Created by Vipul Saluja on 26-10-2021.
 */
interface NetworkApi {
    @GET("api/v1/products.json?brand=maybelline")
    suspend fun getProducts(): Response<List<Product>>
}