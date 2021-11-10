package com.example.myprogressproject.ui.profs

import android.view.ViewGroup
import com.example.core.base.BaseRecyclerViewAdapter
import com.example.core.base.BaseViewHolder
import com.example.core.extension.inflateWithBinding
import com.example.domain.entity.ProfDataModel
import com.example.myprogressproject.R
import com.example.myprogressproject.databinding.ItemProfBinding

class ProfListAdapter : BaseRecyclerViewAdapter() {

    val profDataList: MutableList<ProfDataModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return ProfViewHolder(
            parent.inflateWithBinding(
                R.layout.item_prof
            )
        )
    }

    private inner class ProfViewHolder(
        private val itemProfBinding: ItemProfBinding
    ) : BaseViewHolder(itemProfBinding) {
        override fun bind(position: Int) {

            val item = profDataList[position]

            with(itemProfBinding) {
                profItemBinding = item
            }
        }
    }

    override fun getItemCount() = profDataList.size

    fun setData(profDataList: List<ProfDataModel>) {
        this.profDataList.addAll(profDataList)
        notifyDataSetChanged()
    }
}