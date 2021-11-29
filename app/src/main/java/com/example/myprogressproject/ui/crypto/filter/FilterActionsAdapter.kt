package com.example.myprogressproject.ui.crypto.filter

import android.view.ViewGroup
import com.example.core.base.BaseRecyclerViewAdapter
import com.example.core.base.BaseViewHolder
import com.example.core.extension.inflateWithBinding
import com.example.myprogressproject.R
import com.example.myprogressproject.databinding.ItemCryptoActionBinding
import com.example.myprogressproject.databinding.ItemFilterActionBinding

class FilterActionsAdapter(
    val filterBottomSheetListener: FilterBottomSheetListener
): BaseRecyclerViewAdapter() {

    val filterActionsList = mutableListOf<FilterAction>()

    fun setFilterActions(filterActions: Array<FilterAction>) {
        this.filterActionsList.apply {
            addAll(filterActions)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return CharacterNewItemViewHolder(parent.inflateWithBinding(R.layout.item_filter_action))
    }

    override fun getItemCount(): Int = filterActionsList.size

    private inner class CharacterNewItemViewHolder(private val itemFilterActionBinding: ItemFilterActionBinding) : BaseViewHolder(itemFilterActionBinding) {
        override fun bind(position: Int) {

            val itemFilterAction = filterActionsList[position]
            with(itemFilterActionBinding) {
                itemFilterActionText.text =
                    itemFilterActionText.context.getText(itemFilterAction.title)

                itemFilterActionText.setOnClickListener {
                    filterBottomSheetListener.onFilterClick(itemFilterAction.title)
                }
            }
        }
    }
}