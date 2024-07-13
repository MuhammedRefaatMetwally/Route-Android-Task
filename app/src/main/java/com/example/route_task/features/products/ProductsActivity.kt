package com.example.route_task.features.products
import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.example.route_task.R
import com.example.route_task.databinding.ActivityProductsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductsBinding
    @SuppressLint("CommitTransaction")
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_products)
        applyWindowInsets(binding)
        makeStatusBarTransparentAndIconsClear()
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.product_fragment, ProductsFragment())
                .commit()
        }
    }

    private fun makeStatusBarTransparentAndIconsClear() {
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
        window.statusBarColor = Color.TRANSPARENT
    }

    private fun applyWindowInsets(binding: ViewBinding) {
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
