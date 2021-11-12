package com.example.core.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(liveData: L, body: (T) -> Unit) {
    liveData.observe(this, Observer(body))
}

inline fun <reified T : ViewDataBinding> ViewGroup.inflateWithBinding(
    layoutId: Int,
    attachToRoot: Boolean = false
): T {
    val inflater = LayoutInflater.from(context)

    return inflater.inflateBinding(layoutId, this, attachToRoot)
}

inline fun <reified T : ViewDataBinding> LayoutInflater.inflateBinding(
    layoutId: Int,
    viewGroup: ViewGroup?,
    attachToRoot: Boolean = false
): T = DataBindingUtil.inflate(this, layoutId, viewGroup, attachToRoot)

fun View.show(show: Boolean = true, invisible: Boolean = false) {
    visibility = if (show) {
        View.VISIBLE
    } else {
        if (invisible) View.INVISIBLE else View.GONE
    }
}