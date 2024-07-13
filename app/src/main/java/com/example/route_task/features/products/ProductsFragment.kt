package com.example.route_task.features.products

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.route_task.core.utils.ViewError
import com.example.route_task.core.utils.showMessage
import com.example.route_task.databinding.FragmentProductsBinding
import com.example.route_task.features.products.adapter.ProductsAdapter
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class ProductsFragment : Fragment() {

    private lateinit var binding: FragmentProductsBinding
    private val productsAdapter = ProductsAdapter()
    private val viewModel: ProductsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initObservers()
        viewModel.getProducts()
    }

    private fun initViews() {
        binding.vm = viewModel
        binding.lifecycleOwner = this
        binding.categoryProductsRv.apply {
            adapter = productsAdapter
        }
    }
    private fun initObservers() {
        viewModel.productsLiveData.observe(viewLifecycleOwner) { products ->
            products?.let {
                productsAdapter.bindProducts(it)
            }
        }

        viewModel.errorLiveData.observe(viewLifecycleOwner) { error ->
            handleError(error)
        }
    }

    private fun handleError(viewError: ViewError) {
        showMessage(
            message = viewError.message ?: viewError.throwable?.localizedMessage ?: "Something Went Wrong",
            posActionName = "Try Again",
            posAction = { dialog, _ ->
                dialog.dismiss()
                viewError.onTryAgainClickListener?.onTryAgainClick()
            },
            negActionName = "Cancel",
            negAction = { dialog, _ ->
                dialog.dismiss()
            }
        )
    }
}