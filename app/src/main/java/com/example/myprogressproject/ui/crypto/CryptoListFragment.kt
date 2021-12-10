package com.example.myprogressproject.ui.crypto

import android.content.Context
import android.os.Bundle
import android.util.Log
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
import com.geetest.sdk.GT3ConfigBean
import com.geetest.sdk.GT3ErrorBean
import com.geetest.sdk.GT3GeetestUtils
import java.lang.RuntimeException
import com.geetest.sdk.GT3Listener
import org.json.JSONObject
import android.os.AsyncTask
import com.example.data.remote.HttpUtils
import com.evgfad.captcha.AddressUtils
import com.evgfad.captcha.RiskTypeEnum
import com.example.data.remote.NetRequestUtils
import java.lang.Exception

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
        }
    }

    private fun initCaptcha() {

        gt3ConfigBean.pattern = 1
        gt3ConfigBean.isCanceledOnTouchOutside = false
        gt3ConfigBean.lang = null
        gt3ConfigBean.timeout = 10000
        gt3ConfigBean.webviewTimeout = 10000
        gt3ConfigBean.listener = object : GT3Listener() {
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
                Log.e("TAG", "onButtonClick: ")
                    //RequestAPI1(activity as MainActivity, gt3ConfigBean, gt3GeetestUtils, riskTypeEnum).execute()

            }
        }
        gt3GeetestUtils.init(gt3ConfigBean)
        binding.btnGeetest.setGeetestUtils(gt3GeetestUtils)
    }

    /*internal class RequestAPI1 constructor(val context: Context,
                                           val configBean: GT3ConfigBean,
                                           val gt3GeetestUtils: GT3GeetestUtils,
                                           val riskTypeEnum: com.evgfad.captcha.RiskTypeEnum
    ) :
        AsyncTask<Void?, Void?, JSONObject?>() {

        override fun onPostExecute(parmas: JSONObject?) {
            // 继续验证
            Log.i("TAG", "RequestAPI1-->onPostExecute: $parmas")
            configBean.api1Json = parmas
            gt3GeetestUtils.getGeetest()
        }

        override fun doInBackground(vararg p0: Void?): JSONObject? {
            Log.e("TAG", "doInBackground: ")
            val captchaURL = "https://www.geetest.com/demo/gt/register-click"
            val string: String = HttpUtils.requestGet(captchaURL) ?: ""
            Log.e("TAG", "string: $string")
            var jsonObject: JSONObject? = null
            try {
                val result: String =
                    NetRequestUtils.requestGet(com.evgfad.captcha.AddressUtils.getRegister(context, riskTypeEnum))
                jsonObject = JSONObject(result)
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return jsonObject
        }
    }*/

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