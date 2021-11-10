package com.example.myprogressproject.ui.base

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.request.RequestOptions
import com.example.myprogressproject.ui.base.extension.loadContent

@BindingAdapter(value = ["android:src", "requestOptions"], requireAll = false)
fun ImageView.bindSrc(model: Any?, requestOptions: RequestOptions?) {
    if (model!= null) {
        loadContent(model, requestOptions ?: RequestOptions())
    }
}