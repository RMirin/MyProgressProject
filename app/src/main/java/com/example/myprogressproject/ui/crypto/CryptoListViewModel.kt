package com.example.myprogressproject.ui.crypto

import android.app.Application
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.core.base.BaseViewModel
import com.example.core.base.State
import com.example.domain.entity.CryptoDataModel
import com.example.domain.usecases.CryptoUseCase
import com.example.recaptcha.base.NetworkResult
import com.example.recaptcha.repository.ReCaptchaRepository
import com.example.recaptcha.response.RecaptchaVerifyResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import org.json.JSONObject

import javax.inject.Inject

@HiltViewModel
class CryptoListViewModel @Inject constructor(
    private val cryptoUseCase: CryptoUseCase,
    private val reCaptchaRepository: ReCaptchaRepository,
    app: Application
): BaseViewModel(app) {

    private val _uiState = MutableStateFlow<NetworkResult<RecaptchaVerifyResponse?>>(NetworkResult.Loading())
    val uiState: MutableStateFlow<NetworkResult<RecaptchaVerifyResponse?>>
        get() = _uiState

    val cryptoList: StateFlow<List<CryptoDataModel>> = flow {
        cryptoUseCase.getData().collect { cryptoDataModelList ->
            emit(cryptoDataModelList)
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = emptyList()
    )

    fun getRecaptchaValidation(response: String, key: String) {
        viewModelScope.launch {
            val recaptchaVerificationResult =
                reCaptchaRepository.validateCaptcha(uiState, response, key)
            recaptchaVerificationResult.let { result ->
                Log.e("TAG", "getRecaptchaValidation: ${result.value.message}")
            }
        }
    }

//    suspend fun getCaptcha() = authCaptchaUseCase.getCaptchaParams()
//        .doOnLoading {
//            _uiState.value = State.Loading
//        }
//        .doOnSuccess { jsonObject ->
//            _uiState.value = State.Success(jsonObject)
//        }
//        .doOnError { error ->
//            _uiState.value = State.Error(error)
//        }
//        .launchIn(viewModelScope)
}