package com.example.myprogressproject.ui.crypto

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.evgfad.captcha.network.GeeTestApi
import com.example.domain.entity.CryptoDataModel
import com.example.domain.usecases.CryptoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import okhttp3.ResponseBody

import javax.inject.Inject

@HiltViewModel
class CryptoListViewModel @Inject constructor(
    private val cryptoUseCase: CryptoUseCase,
    private val geeTestApi: GeeTestApi
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

    val captcha: StateFlow<ResponseBody> = flow {
        geeTestApi.registerSlide().collect { cryptoDataModelList ->
            emit(cryptoDataModelList)
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = emptyList()
    )
}