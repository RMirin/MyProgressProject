package com.example.myprogressproject.ui.main.drawer

import com.example.core.base.BaseFragment
import com.example.myprogressproject.databinding.FragmentDrawerBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DrawerFragment : BaseFragment<FragmentDrawerBinding>() {

    override fun initViewBinding(): FragmentDrawerBinding = FragmentDrawerBinding.inflate(layoutInflater)
}