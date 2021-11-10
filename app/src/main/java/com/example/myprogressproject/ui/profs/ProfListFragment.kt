package com.example.myprogressproject.ui.profs

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.core.base.BaseFragment
import com.example.core.base.launchWhenStarted
import com.example.myprogressproject.databinding.FragmentProfListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfListFragment: BaseFragment<FragmentProfListBinding>() {

    private val profListViewModel: ProfListViewModel by viewModels()

    private val profListAdapter: ProfListAdapter by lazy(LazyThreadSafetyMode.NONE) { ProfListAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        observeData()
    }

    private fun initRecycler() {
        with(binding) {
            profListAdapterBinding = profListAdapter
        }
    }

    private fun observeData() {
        with(profListViewModel) {
            profList.launchWhenStarted(lifecycleScope) { profDataList ->
                profListAdapter.setData(profDataList)
            }
        }
    }

    override fun initViewBinding(): FragmentProfListBinding = FragmentProfListBinding.inflate(layoutInflater)
}