package com.example.myprogressproject.ui.crypto

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
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
import com.geetest.sdk.GT3ConfigBean
import com.geetest.sdk.GT3GeetestUtils
import java.lang.RuntimeException
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.CommonStatusCodes
import com.google.android.gms.safetynet.SafetyNet
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CryptoListFragment : BaseFragment<FragmentCryptoListBinding>(), CryptoActionsListener, FilterBottomSheetListener, CryptoListListener {

    private var cryptoListFragmentListener: CryptoListFragmentListener? = null

    private val cryptoListViewModel: CryptoListViewModel by viewModels()

    private val cryptoListAdapter: CryptoListAdapter by lazy(LazyThreadSafetyMode.NONE) { CryptoListAdapter(this) }
    private val cryptoActionsAdapter: CryptoActionsAdapter by lazy(LazyThreadSafetyMode.NONE) { CryptoActionsAdapter(this) }

    private val gt3GeetestUtils: GT3GeetestUtils by lazy(LazyThreadSafetyMode.NONE) { GT3GeetestUtils(activity as MainActivity) }

    val gt3ConfigBean = GT3ConfigBean()

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
//        initCaptcha()
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

    private fun startAuthCaptcha() {
        SafetyNet.getClient(requireActivity()).verifyWithRecaptcha("6LeJYzMeAAAAAAI9NcPv_Zw9QWX69TnEjlNtyx15")
            .addOnSuccessListener { recaptchaTokenResponse ->
                // Indicates communication with reCAPTCHA service was
                // successful.
                val userResponseToken = recaptchaTokenResponse.tokenResult
                if (!userResponseToken!!.isEmpty()) {
                    // Validate the user response token using the
                    // reCAPTCHA siteverify API.
                    Log.e("TAG", "VALIDATION STEP NEEDED")

                    cryptoListViewModel.getRecaptchaValidation(
                        userResponseToken,
                        "6LeJYzMeAAAAAOVOQOXtPGhn-IsHYhP34taYo8-i"
                    )
                }
            }
            .addOnFailureListener { e ->
                if (e is ApiException) {
                    // An error occurred when communicating with the
                    // reCAPTCHA service. Refer to the status code to
                    // handle the error appropriately.
                    val apiException = e as ApiException
                    val statusCode = apiException.statusCode
                    Log.e(
                        "TAG", "Error: " + CommonStatusCodes
                            .getStatusCodeString(statusCode)
                    )
                } else {
                    // A different, unknown type of error occurred.
                    Log.e("TAG", "Error: " + e.message)
                }
            }
    }

//    private fun initCaptcha() {
//        with(gt3ConfigBean) {
//            pattern = 1
//            isCanceledOnTouchOutside = false
//            //Change dialog language
//            lang = "EN"
//            timeout = 10000
//            webviewTimeout = 10000
//            listener = object : BaseGT3Listener() {
//
//                override fun onReceiveCaptchaCode(captcha: Int) {
//                    //captcha: 0 - failed, 1 - passed
//                    if (captcha == 1) {
//                        Toast.makeText((activity as MainActivity), "captcha passed", Toast.LENGTH_SHORT).show()
//                        gt3GeetestUtils.dismissGeetestDialog()
//                    }
//                }
//            }
//        }
//        gt3GeetestUtils.init(gt3ConfigBean)
//    }

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

//            uiState.launchWhenStarted(lifecycleScope) { state ->
//                when(state) {
//                    is State.Loading -> {}
//                    is State.Success -> {
//                        configBean.api1Json = state.data
//                        gt3GeetestUtils.getGeetest()
//                    }
//                    is State.Error -> {}
//                }
//            }
        }
    }

    override fun initViewBinding(): FragmentCryptoListBinding = FragmentCryptoListBinding.inflate(layoutInflater)

    override fun onCryptoActionClicked(cryptoAction: CryptoAction) {
        if (cryptoAction == CryptoAction.VERIFICATION) {
//            gt3GeetestUtils.startCustomFlow()
//            lifecycleScope.launch(Dispatchers.Main) {
//                cryptocryptoListListViewModel.getCaptcha()
//            }
            startAuthCaptcha()
        } else {
            Toast.makeText((activity as MainActivity), cryptoAction.name, Toast.LENGTH_SHORT).show()
        }
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