package com.vipulsaluja.hiltlearningdemo.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vipulsaluja.hiltlearningdemo.R
import com.vipulsaluja.hiltlearningdemo.model.Product

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private var listProduct: List<Product>

    init {
        listProduct = ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_view_product_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        Log.e("Vipul","inside bind view holder")
        holder.txtName.text = listProduct[position].name
        holder.txtBrandName.text = listProduct[position].brand
        holder.txtPrice.text = listProduct[position].price.toString()
    }

    override fun getItemCount(): Int {
        return listProduct.size
    }

    fun updateData(listProduct: List<Product>) {
        this.listProduct = listProduct
        notifyDataSetChanged()
    }

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtName: TextView = itemView.findViewById(R.id.txtName)
        val txtPrice: TextView = itemView.findViewById(R.id.txtPrice)
        val txtBrandName: TextView = itemView.findViewById(R.id.txtBrandName)
    }
}