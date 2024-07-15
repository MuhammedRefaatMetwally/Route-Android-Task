package com.example.route_task.features.products.fragment

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
import com.example.route_task.features.products.fragment.adapter.ProductsAdapter
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class ProductsFragment : Fragment() {


    private val productsAdapter = ProductsAdapter()
    private lateinit var viewModel: ProductsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel  = ViewModelProvider(this)[ProductsViewModel::class.java]
    }

    private  var _viewbinding: FragmentProductsBinding? = null
    private val binding get() = _viewbinding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewbinding = FragmentProductsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initObservers()
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
                productsAdapter.updateProducts(it)
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

    override fun onDestroyView() {
        super.onDestroyView()
        _viewbinding = null
    }
}