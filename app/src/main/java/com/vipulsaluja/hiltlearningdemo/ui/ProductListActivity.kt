package com.vipulsaluja.hiltlearningdemo.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.vipulsaluja.hiltlearningdemo.R
import com.vipulsaluja.hiltlearningdemo.ui.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductListActivity : ComponentActivity() {

    private val  mViewModel: ProductViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        mViewModel.getProductLiveData().observe(this, Observer {
            Log.e("Vipul", "it=${it}")
        })

        mViewModel.fetchProducts()
    }
}