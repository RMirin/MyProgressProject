package com.example.myprogressproject.ui.main

import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.core.base.BaseActivity
import com.example.myprogressproject.R
import com.example.myprogressproject.databinding.ActivityMainBinding
import com.example.myprogressproject.ui.crypto.CryptoListFragmentListener
import com.example.myprogressproject.ui.main.drawer.DrawerFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), CryptoListFragmentListener {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.drawerLy.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)

        val ordSorFrag: Fragment = DrawerFragment()
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.left_drawer, ordSorFrag)
        fragmentTransaction.commit()
    }

//    override fun initViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun openDrawer() {
        binding.drawerLy.openDrawer(Gravity.LEFT)
    }

    override fun onBackPressed() {
        if (binding.drawerLy.isDrawerOpen(Gravity.LEFT)) {
            binding.drawerLy.closeDrawers()
        } else {
            super.onBackPressed()
        }
    }
}
