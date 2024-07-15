package com.example.route_task.features.products.fragment.adapter

import android.annotation.SuppressLint
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.products.model.ProductsItemEntity
import com.example.route_task.databinding.ItemProductBinding
import kotlin.math.round

class ProductsAdapter(private var products: List<ProductsItemEntity?> = emptyList()) :
    RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {

    inner class ViewHolder(var itemProductBinding: ItemProductBinding) :
        RecyclerView.ViewHolder(itemProductBinding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(product: ProductsItemEntity?) {
            itemProductBinding.product = product
            itemProductBinding.executePendingBindings()
            if (product?.discountPercentage != null) {
                val originalPrice = product.price?.div((1 - (product.discountPercentage!! / 100)))
                itemProductBinding.productPrice.text = "EGP ${originalPrice?.let { round(it) }}"
                itemProductBinding.productOldPrice.isVisible = true
                itemProductBinding.productOldPrice.text = "EGP ${product.price}"
                itemProductBinding.productOldPrice.paintFlags =
                    itemProductBinding.productOldPrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            } else {
                itemProductBinding.productPrice.text = "EGP ${product?.price}"
                itemProductBinding.productOldPrice.isVisible = false
            }
            itemProductBinding.reviewValueTv.text = "(${product?.rating})"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = products.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
        addProductToWishListClicked?.let {
            holder.itemProductBinding.addToWishlistBtn.setOnClickListener {
                addProductToWishListClicked?.invoke(product!!)
            }
        }
        addProductToCartClicked?.let {
            holder.itemProductBinding.addToCartBtn.setOnClickListener {
                addProductToCartClicked?.invoke(product!!)
            }
        }
    }

    fun updateProducts(newProducts: List<ProductsItemEntity?>) {
        val diffCallback = ProductDiffCallback(products, newProducts)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        products = newProducts
        diffResult.dispatchUpdatesTo(this)
    }

    var addProductToWishListClicked: ((product: ProductsItemEntity) -> Unit)? = null
    var addProductToCartClicked: ((product: ProductsItemEntity) -> Unit)? = null
}
