package com.example.core.base

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.request.RequestOptions
import com.example.core.extension.loadContent

@BindingAdapter(value = ["android:src", "requestOptions"], requireAll = false)
fun ImageView.bindSrc(model: Any?, requestOptions: RequestOptions?) {
    if (model!= null) {
        loadContent(model, requestOptions ?: RequestOptions())
    }
}

@BindingAdapter("setIntText")
fun TextView.bindSetIntText(text: Int) {
    this.text = text.toString()
}