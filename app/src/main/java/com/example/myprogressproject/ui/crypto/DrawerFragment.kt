package com.example.myprogressproject.ui.crypto

import com.example.core.base.BaseFragment
import com.example.myprogressproject.databinding.DrawerFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DrawerFragment : BaseFragment<DrawerFragmentBinding>() {

    override fun initViewBinding(): DrawerFragmentBinding = DrawerFragmentBinding.inflate(layoutInflater)
}