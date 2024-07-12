package com.example.route_task.core.utils


import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout

class BindingAdapters {
    companion object {
        /*@BindingAdapter("app:urlCircular")
        @JvmStatic
        fun bindImageCircular(imageView: ImageView, url: String?) {
            Picasso.get()
                .load(url)
                .placeholder(R.drawable.ic_category_placeholder)
                .transform(TransformCircular())
                .into(imageView)
        }*/

      /*  @BindingAdapter("app:url")
        @JvmStatic
        fun bindImage(imageView: ImageView, url: String?) {
            Picasso.get()
                .load(url)
                .centerCrop()
                .fit()
                .into(imageView)
        }
*/
    }
}
@BindingAdapter("app:Error")
fun setTextInputLayoutError(textInputLayout: TextInputLayout, error: String?) {
    textInputLayout.error = error
    textInputLayout.errorIconDrawable = null
}

@BindingAdapter("app:clearFocusOnCondition")
fun clearFocusOnCondition(view: View, condition: Boolean) {
    if (condition) {
        view.clearFocus()
    }
}
