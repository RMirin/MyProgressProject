package com.example.core.base

import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewAdapter : RecyclerView.Adapter<BaseViewHolder>() {

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(position)
    }

}