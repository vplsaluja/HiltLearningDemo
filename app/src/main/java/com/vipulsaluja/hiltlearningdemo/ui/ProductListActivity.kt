package com.vipulsaluja.hiltlearningdemo.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vipulsaluja.hiltlearningdemo.R
import com.vipulsaluja.hiltlearningdemo.ui.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductListActivity : ComponentActivity() {

    private val mViewModel: ProductViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        val productList: RecyclerView = findViewById(R.id.rvProductList)
        val progressBar: ProgressBar = findViewById(R.id.progressBar)

        val productAdapter = ProductAdapter()
        productList.adapter = productAdapter
        productList.layoutManager = LinearLayoutManager(this)
        productList.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))


        mViewModel.getProductLiveData().observe(this, {
            progressBar.visibility = View.GONE
            productAdapter.updateData(it)
        })

        progressBar.visibility = View.VISIBLE
        mViewModel.fetchProducts()
    }
}