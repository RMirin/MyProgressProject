package com.example.myprogressproject.ui.crypto

import android.view.ViewGroup
import com.example.core.base.BaseRecyclerViewAdapter
import com.example.core.base.BaseViewHolder
import com.example.core.extension.inflateWithBinding
import com.example.core.extension.loadContent
import com.example.domain.entity.CryptoDataModel
import com.example.myprogressproject.R
import com.example.myprogressproject.databinding.ItemCryptoBinding

class CryptoListAdapter : BaseRecyclerViewAdapter() {

    val cryptoDataList: MutableList<CryptoDataModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return ProfViewHolder(
            parent.inflateWithBinding(
                R.layout.item_crypto
            )
        )
    }

    private inner class ProfViewHolder(
        private val itemCryptoBinding: ItemCryptoBinding
    ) : BaseViewHolder(itemCryptoBinding) {
        override fun bind(position: Int) {

            val item = cryptoDataList[position]
            with(itemCryptoBinding) {
                cryptoItemBinding = item
            }
        }
    }

    override fun getItemCount() = cryptoDataList.size

    fun setData(cryptoDataList: List<CryptoDataModel>) {
        this.cryptoDataList.addAll(cryptoDataList)
        notifyDataSetChanged()
    }
}