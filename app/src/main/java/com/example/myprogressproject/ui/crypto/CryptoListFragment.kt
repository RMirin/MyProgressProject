package com.example.myprogressproject.ui.crypto

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.captcha.util.State
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
import com.geetest.sdk.GT3ErrorBean
import com.geetest.sdk.GT3GeetestUtils
import java.lang.RuntimeException
import com.geetest.sdk.GT3Listener
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
        initCaptcha()
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
            btnGeetest.setOnClickListener {
                gt3GeetestUtils.startCustomFlow()
                lifecycleScope.launch(Dispatchers.Main) {
                    cryptoListViewModel.getCaptcha()
                }
            }
        }
    }

    private fun initCaptcha() {
        gt3ConfigBean.apply {
            pattern = 1
            isCanceledOnTouchOutside = false
            lang = null
            timeout = 10000
            webviewTimeout = 10000
            listener = object : GT3Listener() {
                /**
                 * CAPTCHA loading is completed
                 * @param duration Loading duration and version info，in JSON format
                 */
                override fun onDialogReady(duration: String) {
                    Log.e("TAG", "GT3BaseListener-->onDialogReady-->$duration")
                }

                /**
                 * Verification result callback
                 * @param code 1:success, 0:fail
                 */
                override fun onReceiveCaptchaCode(code: Int) {
                    Log.e("TAG", "GT3BaseListener-->onReceiveCaptchaCode-->$code")

                }

                /**
                 * api2 custom call
                 * @param result
                 */
                override fun onDialogResult(result: String) {
                    Log.e("TAG", "GT3BaseListener-->onDialogResult-->$result")
                    // Start api2 workflow
//                    RequestAPI2().execute(result)
                }

                /**
                 * Statistic info.
                 * @param result
                 */
                override fun onStatistics(result: String) {
                    Log.e("TAG", "GT3BaseListener-->onStatistics-->$result")
                }

                /**
                 * Close the CAPTCHA
                 * @param num 1 Click the close button to close the CAPTCHA, 2 Click anyplace on screen to close the CAPTCHA, 3 Click return button the close
                 */
                override fun onClosed(num: Int) {
                    Log.e("TAG", "GT3BaseListener-->onClosed-->$num")
                }

                /**
                 * Verfication succeeds
                 * @param result
                 */
                override fun onSuccess(result: String) {
                    Log.e("TAG", "GT3BaseListener-->onSuccess-->$result")
                }

                /**
                 * Verification fails
                 * @param errorBean Version info, error code & description, etc.
                 */
                override fun onFailed(errorBean: GT3ErrorBean) {
                    Log.e("TAG", "GT3BaseListener-->onFailed-->$errorBean")
                }

                /**
                 * api1 custom call
                 */
                override fun onButtonClick() {
                    Log.d("TAG", "onButtonClick: ")
                }
            }
        }
        gt3GeetestUtils.init(gt3ConfigBean)
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

            uiState.launchWhenStarted(lifecycleScope) { state ->
                when(state) {
                    is State.Loading -> {}
                    is State.Success -> {
                        gt3ConfigBean.api1Json = state.data
                        gt3GeetestUtils.getGeetest()
                    }
                    is State.Error -> {}
                }
            }
        }
    }

    override fun initViewBinding(): FragmentCryptoListBinding = FragmentCryptoListBinding.inflate(layoutInflater)

    override fun onCryptoActionClicked(cryptoAction: CryptoAction) {
        if (cryptoAction == CryptoAction.VERIFICATION) {
            gt3GeetestUtils.startCustomFlow()
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