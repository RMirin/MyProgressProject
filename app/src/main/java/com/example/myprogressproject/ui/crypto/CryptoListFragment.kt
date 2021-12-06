package com.example.myprogressproject.ui.crypto

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.core.base.BaseFragment
import com.example.core.extension.launchWhenStarted
import com.example.core.extension.MemberItemDecoration
import com.example.myprogressproject.databinding.FragmentCryptoListBinding
import com.example.myprogressproject.ui.crypto.actions.CryptoAction
import com.example.myprogressproject.ui.crypto.actions.CryptoActionsAdapter
import com.example.myprogressproject.ui.crypto.actions.CryptoActionsListener
import dagger.hilt.android.AndroidEntryPoint
import com.example.myprogressproject.ui.crypto.filter.FilterBottomSheetFragment
import com.example.myprogressproject.ui.crypto.filter.FilterBottomSheetListener
import com.example.myprogressproject.ui.main.MainActivity
import java.lang.RuntimeException

@AndroidEntryPoint
class CryptoListFragment : BaseFragment<FragmentCryptoListBinding>(), CryptoActionsListener, FilterBottomSheetListener, CryptoListListener {

    private var cryptoListFragmentListener: CryptoListFragmentListener? = null

    private val cryptoListViewModel: CryptoListViewModel by viewModels()

    private val cryptoListAdapter: CryptoListAdapter by lazy(LazyThreadSafetyMode.NONE) { CryptoListAdapter(this) }
    private val cryptoActionsAdapter: CryptoActionsAdapter by lazy(LazyThreadSafetyMode.NONE) { CryptoActionsAdapter(this) }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            cryptoListFragmentListener = context as CryptoListFragmentListener
        } catch (ex: RuntimeException) {
            Toast.makeText(
                (activity as MainActivity), context.toString()
                        + " must implement OnFragmentInteractionListener", Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onDetach() {
        super.onDetach()
        cryptoListFragmentListener = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        observeData()
        initView()
    }

    private fun initView() {
        with(binding) {
            searchImg.setOnClickListener {
                visibilityOnClicked(View.GONE, searchImg)
                visibilityOnClicked(View.VISIBLE, searchEt)
                visibilityOnClicked(View.VISIBLE, capitalizationText)

                searchEt.requestFocus()
                val inputMethodManager = context
                    ?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.showSoftInput(searchEt, InputMethodManager.SHOW_IMPLICIT)
            }

            searchEt.onFocusChangeListener = View.OnFocusChangeListener { _, focus ->
                appbar.setExpanded(!focus)

                if (focus) {
                    visibilityOnClicked(View.GONE, searchImg)
                    visibilityOnClicked(View.VISIBLE, searchEt)
                    visibilityOnClicked(View.VISIBLE, capitalizationText)
                } else {
                    visibilityOnClicked(View.VISIBLE, searchImg)
                    visibilityOnClicked(View.INVISIBLE, searchEt)
                    visibilityOnClicked(View.GONE, capitalizationText)
                }
            }

            capitalizationText.setOnClickListener {
                FilterBottomSheetFragment(this@CryptoListFragment).show(
                    (activity as MainActivity).supportFragmentManager,
                    "tag"
                )
            }
        }
    }

    private fun initRecycler() {
        with(binding) {
            profListRecycler.adapter = cryptoListAdapter
            cryptoListActionsRecycler.adapter = cryptoActionsAdapter
            cryptoListActionsRecycler.addItemDecoration(MemberItemDecoration())
        }

        cryptoActionsAdapter.setCryptoActions(CryptoAction.values())
    }

    private fun visibilityOnClicked(visible: Int, visibilityView: View) {
        visibilityView.visibility = visible
    }

    private fun observeData() {
        with(cryptoListViewModel) {
            cryptoList.launchWhenStarted(lifecycleScope) { cryptoDataList ->
                cryptoListAdapter.setData(cryptoDataList)
            }
        }
    }

    override fun initViewBinding(): FragmentCryptoListBinding = FragmentCryptoListBinding.inflate(layoutInflater)

    override fun onCryptoActionClicked(cryptoAction: CryptoAction) {
        Toast.makeText((activity as MainActivity), cryptoAction.name, Toast.LENGTH_SHORT).show()
    }

    override fun onFilterClick(filer: Int) {
        Toast.makeText((activity as MainActivity), filer, Toast.LENGTH_SHORT).show()
    }

    override fun onCryptoInListClicked() {
        cryptoListFragmentListener?.openDrawer()
    }
}

interface CryptoListFragmentListener {
    fun openDrawer()
}