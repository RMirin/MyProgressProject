package com.example.myprogressproject.ui.crypto.actions

import android.view.ViewGroup
import com.example.core.base.BaseRecyclerViewAdapter
import com.example.core.base.BaseViewHolder
import com.example.core.extension.inflateWithBinding
import com.example.myprogressproject.R
import com.example.myprogressproject.databinding.ItemCryptoActionBinding

class CryptoActionsAdapter(
    private val cryptoActionsListener: CryptoActionsListener
): BaseRecyclerViewAdapter() {

    val cryptoActionsList = mutableListOf<CryptoAction>()

    fun setCryptoActions(cryptoActions: Array<CryptoAction>) {
        this.cryptoActionsList.apply {
            clear()
            addAll(cryptoActions)
        }

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return CharacterNewItemViewHolder(parent.inflateWithBinding(R.layout.item_crypto_action))
    }

    override fun getItemCount(): Int = cryptoActionsList.size

    private inner class CharacterNewItemViewHolder(private val itemCryptoActionBinding: ItemCryptoActionBinding) : BaseViewHolder(itemCryptoActionBinding) {
        override fun bind(position: Int) {

            with(itemCryptoActionBinding) {
                cryptoActionBinding = cryptoActionsList[position]
            }
        }
    }
}

interface CryptoActionsListener {
    fun onCryptoActionClicked(cryptoAction: CryptoAction)
}