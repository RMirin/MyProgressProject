package com.example.myprogressproject.ui.crypto.filter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myprogressproject.R
import com.example.myprogressproject.databinding.BottomSheetLayoutBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class FilterBottomSheetFragment(
    private val listener: FilterBottomSheetListener
) : BottomSheetDialogFragment() {

    lateinit var binding: BottomSheetLayoutBinding

    override fun getTheme() = R.style.BottomSheetDialogTheme

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = BottomSheetLayoutBinding.bind(inflater.inflate(R.layout.bottom_sheet_layout, container))

        val adapter = FilterActionsAdapter(listener)
        adapter.setFilterActions(FilterAction.values())
        binding.bottomSheetLayoutRecycler.adapter = adapter

        return binding.root
    }
}

interface FilterBottomSheetListener {
    fun onFilterClick(filer: Int)
}