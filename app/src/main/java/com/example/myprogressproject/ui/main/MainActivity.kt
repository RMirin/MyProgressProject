package com.example.myprogressproject.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.core.base.BaseActivity
import com.example.myprogressproject.R
import com.example.myprogressproject.databinding.ActivityMainBinding
import com.example.myprogressproject.ui.crypto.CryptoListFragment
import com.example.myprogressproject.ui.crypto.DrawerFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(), CryptoListFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val ordSorFrag: Fragment = DrawerFragment()
        val r: FragmentTransaction = supportFragmentManager.beginTransaction()
        r.replace(R.id.right_drawer, ordSorFrag)
        r.commit()
    }

    override fun initViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
    
    override fun openDrawer() {
        binding.drawerLy.openDrawer(Gravity.LEFT)
    }

    override fun closeDrawer() {

    }
}
