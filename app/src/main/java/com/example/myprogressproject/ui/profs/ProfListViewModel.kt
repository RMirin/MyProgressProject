package com.example.myprogressproject.ui.profs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.ProfDataModel
import com.example.domain.usecases.ProfessionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*

import javax.inject.Inject

@HiltViewModel
class ProfListViewModel @Inject constructor(
    private val professionsUseCase: ProfessionsUseCase
): ViewModel() {

    val profList: StateFlow<List<ProfDataModel>> = flow {
        professionsUseCase.getData().collect { profDataModelList ->
            emit(profDataModelList)
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = emptyList()
    )
}