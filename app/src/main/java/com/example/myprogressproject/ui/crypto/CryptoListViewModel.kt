package com.example.myprogressproject.ui.crypto

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.captcha.domain.usecase.CaptchaUseCase
import com.example.captcha.util.State
import com.example.captcha.extension.doOnError
import com.example.captcha.extension.doOnLoading
import com.example.captcha.extension.doOnSuccess
import com.example.domain.entity.CryptoDataModel
import com.example.domain.usecases.CryptoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import org.json.JSONObject

import javax.inject.Inject

@HiltViewModel
class CryptoListViewModel @Inject constructor(
    private val cryptoUseCase: CryptoUseCase,
    private val captchaUseCase: CaptchaUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow<State<JSONObject?>>(State.Loading)
    val uiState: StateFlow<State<JSONObject?>>
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

    suspend fun getCaptcha() = captchaUseCase.registerSlide()
        .doOnLoading {
            _uiState.value = State.Loading
        }
        .doOnSuccess { jsonObject ->
            _uiState.value = State.Success(jsonObject)
        }
        .doOnError { error ->
            _uiState.value = State.Error(error)
        }
        .launchIn(viewModelScope)
}