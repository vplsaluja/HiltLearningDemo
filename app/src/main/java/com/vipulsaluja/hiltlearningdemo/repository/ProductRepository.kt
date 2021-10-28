package com.vipulsaluja.hiltlearningdemo.repository

import com.vipulsaluja.hiltlearningdemo.model.Product
import rx.Observable


/**
 * Created by Vipul Saluja on 26-10-2021.
 */
interface ProductRepository {
    suspend fun getProducts(): List<Product>?
}