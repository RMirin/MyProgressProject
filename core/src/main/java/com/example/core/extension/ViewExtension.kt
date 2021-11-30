package com.example.core.extension

import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

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

fun ImageView.loadContent(model: Any, requestOptions: RequestOptions = RequestOptions()) {
    Glide.with(this)
        .load(model)
        .thumbnail(0.1f)
        .apply(requestOptions)
        .into(this)
}

class MemberItemDecoration : ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        if (parent.getChildAdapterPosition(view) == parent.adapter!!.itemCount - 1) {
            outRect.right = 50 /* set your margin here */
        }
    }
}