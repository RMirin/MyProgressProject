package com.example.myprogressproject.ui.base.extension

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.loadContent(model: Any, requestOptions: RequestOptions = RequestOptions()) {
    Glide.with(this)
        .load(model)
        .thumbnail(0.1f)
        .apply(requestOptions)
        .into(this)
}