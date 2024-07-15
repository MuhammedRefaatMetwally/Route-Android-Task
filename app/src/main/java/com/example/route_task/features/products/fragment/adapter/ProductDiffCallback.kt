package com.example.route_task.features.products.fragment.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.domain.products.model.ProductsItemEntity

//DiffUtils
    class ProductDiffCallback(
    private val oldList: List<ProductsItemEntity?>,
    private val newList: List<ProductsItemEntity?>
    ) : DiffUtil.Callback() {

        override fun getOldListSize() = oldList.size

        override fun getNewListSize() = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldItem = oldList[oldItemPosition]
            val newItem = newList[newItemPosition]
            return oldItem?.id == newItem?.id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldItem = oldList[oldItemPosition]
            val newItem = newList[newItemPosition]
            return oldItem == newItem
        }
    }