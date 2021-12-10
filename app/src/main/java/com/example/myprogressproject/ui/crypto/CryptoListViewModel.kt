package com.example.myprogressproject.ui.crypto

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.CryptoDataModel
import com.example.domain.usecases.CryptoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import org.json.JSONObject

import javax.inject.Inject

@HiltViewModel
class CryptoListViewModel @Inject constructor(
    private val cryptoUseCase: CryptoUseCase
): ViewModel() {

    val cryptoList: StateFlow<List<CryptoDataModel>> = flow {
        cryptoUseCase.getData().collect { cryptoDataModelList ->
            emit(cryptoDataModelList)
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = emptyList()
    )

//    val captchaParams: StateFlow<JSONObject?> = flow {
//        cryptoUseCase.getCaptchaParams().collect {
//            params -> emit(params)
//        }
//    }.stateIn(
//        scope = viewModelScope,
//        started = SharingStarted.Eagerly,
//        initialValue = JSONObject()
//    )
}