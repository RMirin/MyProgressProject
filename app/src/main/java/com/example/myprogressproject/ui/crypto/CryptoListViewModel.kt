package com.example.myprogressproject.ui.crypto

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.compose.authcaptcha.base.State
import com.compose.authcaptcha.extension.doOnError
import com.compose.authcaptcha.extension.doOnLoading
import com.compose.authcaptcha.extension.doOnSuccess
import com.example.core.base.BaseViewModel
import com.example.domain.entity.CryptoDataModel
import com.compose.authcaptcha.usecases.AuthCaptchaUseCase
import com.example.domain.usecases.CryptoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import org.json.JSONObject

import javax.inject.Inject

@HiltViewModel
class CryptoListViewModel @Inject constructor(
    private val cryptoUseCase: CryptoUseCase,
    private val authCaptchaUseCase: AuthCaptchaUseCase,
    app: Application
): BaseViewModel(app) {

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

    suspend fun getCaptcha() = authCaptchaUseCase.getCaptchaParams()
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