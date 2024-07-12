package com.example.route_task.features.home.products

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.route_task.R

class ProductAdapter(private val productList: List<Product>? = null) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_products, parent, false)
        return ProductViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList?.get(position)
        if (product != null) {
            holder.productName.text = product.name
        }
        if (product != null) {
            holder.productPrice.text = product.price
        }
        if (product != null) {
            holder.productReview.text = "Review: ${product.review}"
        }
        if (product != null) {
            holder.productImage.setImageResource(product.imageResId)
        } // Assuming you have drawable resources
    }

    override fun getItemCount(): Int {
        return productList?.size ?: 0
    }

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productImage: ImageView = itemView.findViewById(R.id.imageProduct)
        val productName: TextView = itemView.findViewById(R.id.textProductName)
        val productPrice: TextView = itemView.findViewById(R.id.textProductPrice)
        val productReview: TextView = itemView.findViewById(R.id.textProductRating)
        val favoriteIcon: ImageView = itemView.findViewById(R.id.buttonFavorite)
    }
}
