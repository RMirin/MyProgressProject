package com.example.myprogressproject.ui.crypto

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.core.base.BaseViewModel
import com.example.core.base.Event
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

    private val _uiState =
        MutableStateFlow<NetworkResult<RecaptchaVerifyResponse?>>(NetworkResult.Loading())
    val uiState: MutableStateFlow<NetworkResult<RecaptchaVerifyResponse?>>
        get() = _uiState

    private val _userIsHuman = MutableLiveData<Event<Boolean>>()
    val userIsHuman: MutableLiveData<Event<Boolean>> get() = _userIsHuman

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
                _userIsHuman.value = Event(result.value.data?.success ?: false)
                Log.e("TAG", "getRecaptchaValidation: ${result.value.data}")
            }
        }
    }
}